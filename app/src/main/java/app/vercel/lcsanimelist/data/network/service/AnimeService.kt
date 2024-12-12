package app.vercel.lcsanimelist.data.network.service

import app.vercel.lcsanimelist.data.network.dto.AnimeListResponseDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface AnimeService {
    @GET("anime")
    suspend fun getAnimeList(
        @QueryMap query: Map<String, String>
    ): AnimeListResponseDto
}