package app.vercel.lcsanimelist.data.repository

import androidx.room.util.query
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.dao.AnimeSearchHintDao
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity
import app.vercel.lcsanimelist.data.mapper.toAnimeEntity
import app.vercel.lcsanimelist.data.mapper.toDomainModel
import app.vercel.lcsanimelist.data.mapper.toQueryMap
import app.vercel.lcsanimelist.data.network.service.AnimeService
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.QueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AnimeRepositoryImpl(
    private val animeService: AnimeService,
    private val animeDao: AnimeDao,
    private val animeSearchHintDao: AnimeSearchHintDao,
) : AnimeRepository {
    override fun getAnimeList(query: QueryParameters): Flow<PaginatedResult<Anime>> = flow {
        coroutineScope {
            try {
                val responseDto = animeService.getAnimeList(query.toQueryMap())
                val animeList = responseDto.data.map { animeDto ->
                    async {
                        val favorite = animeDao.getFavoriteById(animeDto.id)
                        animeDto.toDomainModel(favorite).also { anime ->
                            favorite?.let { updateFavorite(anime) }
                        }
                    }
                }.awaitAll()

                emit(PaginatedResult(animeList, responseDto.pagination.hasNextPage))
            } catch (e: Exception) {
                throw TODO()
            }
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun updateFavorite(anime: Anime): Boolean {
        return try {
            val rowsAffect = animeDao.updateFavorite(anime.toAnimeEntity())
            rowsAffect > 0
        } catch (e: Exception) {
            throw TODO()
        }
    }

    override suspend fun addFavorite(anime: Anime) {
        try {
            animeDao.insertFavorite(anime.toAnimeEntity())
        } catch (e: Exception) {
            throw TODO()
        }
    }

    override suspend fun removeFavorite(anime: Anime): Boolean {
        return try {
            val rowsAffected = animeDao.deleteFavorite(anime.toAnimeEntity())
            rowsAffected > 0
        } catch (e: Exception) {
            throw TODO()
        }
    }

    override fun getAnimeSearchHints(query: QueryParameters): Flow<List<AnimeSearchHint>> = flow {
        coroutineScope {
            try {
                if (query.search.isNullOrBlank()) {
                    val searchHistoryResult = animeSearchHintDao.getRecentHistory(query.limit)
                    val animeSearchHints = searchHistoryResult.map { it.toDomainModel() }

                    emit(animeSearchHints)
                } else {
                    val historyDeferred = async { animeSearchHintDao.findInHistory(query.search.trim()) }
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
            } catch (e: Exception) {
                throw TODO()
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun addToSearchHistory(searchQuery: String) {
        try {
            animeSearchHintDao.insertIntoHistory(AnimeSearchHintEntity(searchQuery))
        } catch (e: Exception) {
            throw TODO()
        }
    }
}