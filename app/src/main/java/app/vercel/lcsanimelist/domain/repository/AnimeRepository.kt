package app.vercel.lcsanimelist.domain.repository

import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.QueryParameters
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getAnimeList(query: QueryParameters): Flow<PaginatedResult<Anime>>
    suspend fun updateFavorite(anime: Anime): Boolean
    suspend fun addFavorite(anime: Anime): Boolean
    suspend fun removeFavorite(anime: Anime): Boolean
}