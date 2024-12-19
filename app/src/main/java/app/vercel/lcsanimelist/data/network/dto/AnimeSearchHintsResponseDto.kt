package app.vercel.lcsanimelist.data.network.dto

import com.google.gson.annotations.SerializedName

data class AnimeSearchHintsResponseDto (
    @SerializedName("data") val data: List<AnimeSearchHintDto>
)