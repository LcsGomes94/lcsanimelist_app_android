package app.vercel.lcsanimelist.data.remote.service

import app.vercel.lcsanimelist.data.remote.dto.AnimeListResponseDto
import app.vercel.lcsanimelist.data.remote.dto.AnimeSearchHintsResponseDto
import app.vercel.lcsanimelist.data.remote.dto.AnimeSeasonsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AnimeService {
    @GET("anime")
    suspend fun getAnimeList(
        @QueryMap query: Map<String, String>,
        @Query("page") page: Int
    ): AnimeListResponseDto

    @GET("anime")
    suspend fun getAnimeSearchHints(
        @QueryMap query: Map<String, String>
    ): AnimeSearchHintsResponseDto

    @GET("seasons")
    suspend fun getAvailableSeasons(): AnimeSeasonsResponseDto

    @GET("seasons/{year}/{season}")
    suspend fun getSeasonalAnimeList(
        @Path("year") year: Int,
        @Path("season") season: String,
        @QueryMap query: Map<String, String>,
        @Query("page") page: Int
    ): AnimeListResponseDto
}