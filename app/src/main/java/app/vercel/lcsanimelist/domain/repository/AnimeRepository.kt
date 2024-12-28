package app.vercel.lcsanimelist.domain.repository

import androidx.paging.PagingData
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.LocalQueryParameters
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getAnimeList(query: RemoteQueryParameters): Flow<PagingData<Anime>>

    fun getFavoriteAnimeList(query: LocalQueryParameters): Flow<PagingData<Anime>>
    suspend fun updateFavorite(anime: Anime): Boolean
    suspend fun addFavorite(anime: Anime)
    suspend fun removeFavorite(anime: Anime): Boolean

    fun getAnimeSearchHints(query: RemoteQueryParameters): Flow<List<AnimeSearchHint>>
    suspend fun addToSearchHistory(searchQuery: String)
    fun getFavoriteSearchHints(query: LocalQueryParameters) : Flow<List<AnimeSearchHint>>

    suspend fun getAvailableSeasons(): List<AnimeSeason>
    fun getSeasonalAnimeList(season: AnimeSeason, query: RemoteQueryParameters): Flow<PagingData<Anime>>
}