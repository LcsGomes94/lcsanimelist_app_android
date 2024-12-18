package app.vercel.lcsanimelist.domain.repository

import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.QueryParameters
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getAnimeList(query: QueryParameters): Flow<PaginatedResult<Anime>>
    suspend fun updateFavorite(anime: Anime): Boolean
    suspend fun addFavorite(anime: Anime)
    suspend fun removeFavorite(anime: Anime): Boolean

    fun getAnimeSearchHints(query: QueryParameters): Flow<List<AnimeSearchHint>>
    suspend fun addToSearchHistory(searchQuery: String)
}