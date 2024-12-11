package app.vercel.lcsanimelist.data.network.dto

import com.google.gson.annotations.SerializedName

data class AnimeListResponseDto(
    @SerializedName("pagination") val pagination: PaginationDto,
    @SerializedName("data") val data: List<AnimeDto>
)

data class PaginationDto(
    @SerializedName("has_next_page") val hasNextPage: Boolean,
)
