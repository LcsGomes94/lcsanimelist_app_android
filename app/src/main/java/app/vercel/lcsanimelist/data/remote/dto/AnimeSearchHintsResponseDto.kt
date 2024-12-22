package app.vercel.lcsanimelist.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AnimeSearchHintsResponseDto (
    @SerializedName("data") val data: List<AnimeSearchHintDto>
)