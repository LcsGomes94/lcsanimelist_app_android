package app.vercel.lcsanimelist.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnimeSeasonsResponseDto(
    @SerializedName("data") val seasons: List<AnimeSeasonDto>
)
