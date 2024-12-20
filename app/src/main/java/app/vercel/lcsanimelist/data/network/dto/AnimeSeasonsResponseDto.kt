package app.vercel.lcsanimelist.data.network.dto

import com.google.gson.annotations.SerializedName

data class AnimeSeasonsResponseDto(
    @SerializedName("data") val seasons: List<AnimeSeasonDto>
)
