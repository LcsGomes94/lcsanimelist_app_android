package app.vercel.lcsanimelist.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnimeSearchHintDto(
    @SerializedName("title") val title: String
)
