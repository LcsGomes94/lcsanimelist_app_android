package app.vercel.lcsanimelist.data.repository

import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.network.service.AnimeService
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.QueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeRepositoryImpl(
    private val animeService: AnimeService,
    private val animeDao: AnimeDao
) : AnimeRepository {
    override fun getAnimeList(query: QueryParameters): Flow<PaginatedResult<Anime>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateFavorite(anime: Anime): Boolean {
        TODO("Not yet implemented")
    }
}