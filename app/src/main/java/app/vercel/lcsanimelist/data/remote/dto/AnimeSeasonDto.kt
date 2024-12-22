package app.vercel.lcsanimelist.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnimeSeasonDto(
    @SerializedName("year") val year: Int,
    @SerializedName("seasons") val seasons: List<String>
)
