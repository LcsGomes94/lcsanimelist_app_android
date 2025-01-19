package app.vercel.lcsanimelist.data.repository

import android.database.sqlite.SQLiteException
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.dao.AnimeSearchHistoryDao
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity
import app.vercel.lcsanimelist.data.mapper.toAnimeEntity
import app.vercel.lcsanimelist.data.mapper.toAnimeSearchHints
import app.vercel.lcsanimelist.data.mapper.toAnimeWithGenres
import app.vercel.lcsanimelist.data.mapper.toDomainModel
import app.vercel.lcsanimelist.data.mapper.toQueryMap
import app.vercel.lcsanimelist.data.paging.AnimesPagingSource
import app.vercel.lcsanimelist.data.paging.FavoriteAnimesPagingSource
import app.vercel.lcsanimelist.data.paging.SeasonalAnimesPagingSource
import app.vercel.lcsanimelist.data.remote.service.AnimeService
import app.vercel.lcsanimelist.domain.exception.RepositoryException
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.LocalQueryParameters
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class AnimeRepositoryImpl(
    private val animeService: AnimeService,
    private val animeDao: AnimeDao,
    private val animeSearchHistoryDao: AnimeSearchHistoryDao,
) : AnimeRepository {

    override fun getAnimeList(query: RemoteQueryParameters): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(pageSize = query.limit, enablePlaceholders = false),
            pagingSourceFactory = { AnimesPagingSource(animeService, animeDao, query) }
        ).flow.flowOn(Dispatchers.IO)
    }

    override fun getFavoriteAnimeList(query: LocalQueryParameters): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(pageSize = query.limit, enablePlaceholders = false),
            pagingSourceFactory = { FavoriteAnimesPagingSource(animeDao, query) }
        ).flow.flowOn(Dispatchers.IO)
    }

    override suspend fun updateFavorite(anime: Anime): Boolean = withContext(Dispatchers.IO) {
        try {
            val rowsAffect = animeDao.updateFavorite(anime.toAnimeEntity())
            rowsAffect > 0
        } catch (e: SQLiteException) {
            throw RepositoryException.DatabaseException("Failed to update favorite anime.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }

    override suspend fun addFavorite(anime: Anime) = withContext(Dispatchers.IO) {
        try {
            animeDao.insertFavorite(anime.toAnimeWithGenres())
        } catch (e: SQLiteException) {
            throw RepositoryException.DatabaseException("Failed to add favorite anime.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }

    override suspend fun removeFavorite(anime: Anime): Boolean = withContext(Dispatchers.IO) {
        try {
            val rowsAffected = animeDao.deleteFavorite(anime.toAnimeEntity())
            rowsAffected > 0
        } catch (e: SQLiteException) {
            throw RepositoryException.DatabaseException("Failed to delete favorite anime.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }

    override fun getAnimeSearchHints(query: RemoteQueryParameters): Flow<List<AnimeSearchHint>> = flow {
        coroutineScope {
            try {
                if (query.search.isNullOrBlank()) {
                    val searchHistoryResult = animeSearchHistoryDao.getRecentHistory(query.limit)
                    val animeSearchHints = searchHistoryResult.map { it.toDomainModel() }

                    emit(animeSearchHints)
                } else {
                    val historyDeferred = async { animeSearchHistoryDao.findInHistory(query.search, query.limit) }
                    val hintsDeferred = async { animeService.getAnimeSearchHints(query.toQueryMap()) }
                    val searchHistoryResponse = historyDeferred.await()
                    val searchHintResponse = hintsDeferred.await()

                    val searchHistorySet = searchHistoryResponse.map { it.query.lowercase() }.toSet()
                    val combinedResults = buildList {
                        addAll(searchHistoryResponse.map { it.toDomainModel() })
                        addAll(searchHintResponse.data
                            .filter { it.title.lowercase() !in searchHistorySet }
                            .map { it.toDomainModel() }
                        )
                    }

                    emit(combinedResults)
                }
            } catch (e: SQLiteException) {
                throw RepositoryException.DatabaseException("Failed to get search history.\n" + e.message, e)
            } catch (e: HttpException) {
                throw RepositoryException.NetworkException("Failed to get anime search hints.\n" + e.message, e)
            } catch (e: Exception) {
                throw RepositoryException.UnknownException("Unexpected error occurred.", e)
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun addToSearchHistory(searchQuery: String) = withContext(Dispatchers.IO) {
        try {
            animeSearchHistoryDao.insertIntoHistory(AnimeSearchHintEntity(searchQuery))
        } catch (e: SQLiteException) {
            throw RepositoryException.DatabaseException("Failed to add to search history.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }

    override fun getFavoriteSearchHints(query: LocalQueryParameters): Flow<List<AnimeSearchHint>> = flow {
        try {
            val favoriteAnimeTitles = animeDao.getFavoriteAnimeTitles(
                query.personalStage.ordinal,
                query.search,
                query.orderBy.name,
                query.genres.map { it.id },
                query.genres.size,
                query.limit
            )

            emit(favoriteAnimeTitles.toAnimeSearchHints())
        } catch (e: SQLiteException) {
            throw RepositoryException.DatabaseException("Failed to get favorite search hints.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getAvailableSeasons(): List<AnimeSeason> = withContext(Dispatchers.IO) {
        try {
            val responseDto = animeService.getAvailableSeasons()
            responseDto.seasons.toDomainModel()
        } catch (e: HttpException) {
            throw RepositoryException.NetworkException("Failed to get available season.\n" + e.message, e)
        } catch (e: Exception) {
            throw RepositoryException.UnknownException("Unexpected error occurred.", e)
        }
    }

    override fun getSeasonalAnimeList(season: AnimeSeason, query: RemoteQueryParameters): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(pageSize = query.limit, enablePlaceholders = false),
            pagingSourceFactory = { SeasonalAnimesPagingSource(animeService, animeDao, season, query) }
        ).flow.flowOn(Dispatchers.IO)
    }

}