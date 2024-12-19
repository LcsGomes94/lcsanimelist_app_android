package app.vercel.lcsanimelist.data.network.dto

import com.google.gson.annotations.SerializedName

data class AnimeSearchHintDto(
    @SerializedName("title") val title: String
)
