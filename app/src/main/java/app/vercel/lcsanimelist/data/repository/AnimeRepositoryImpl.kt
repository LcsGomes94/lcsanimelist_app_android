package app.vercel.lcsanimelist.data.repository

import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.mapper.toAnimeEntity
import app.vercel.lcsanimelist.data.mapper.toDomainModel
import app.vercel.lcsanimelist.data.mapper.toQueryMap
import app.vercel.lcsanimelist.data.network.service.AnimeService
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.QueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeRepositoryImpl(
    private val animeService: AnimeService,
    private val animeDao: AnimeDao
) : AnimeRepository {
    override fun getAnimeList(query: QueryParameters): Flow<PaginatedResult<Anime>> = flow {
        coroutineScope {
            try {
                val responseDto = animeService.getAnimeList(query.toQueryMap())
                val animeList = responseDto.data.map { animeDto ->
                    async(Dispatchers.IO) {
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

    }

    override suspend fun updateFavorite(anime: Anime): Boolean {
        return try {
            val rowsAffect = animeDao.updateFavorite(anime.toAnimeEntity())
            rowsAffect > 0
        } catch (e: Exception) {
            throw TODO()
        }
    }

    override suspend fun addFavorite(anime: Anime): Boolean {
        return try {
            animeDao.insertFavorite(anime.toAnimeEntity())
            true
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
}