package app.vercel.lcsanimelist.data.network.dto

import com.google.gson.annotations.SerializedName

data class AnimeDto(
    @SerializedName("mal_id") val id: Int,
    @SerializedName("images") val images: AnimeImagesDto,
    @SerializedName("title") val title: String,
    @SerializedName("episodes") val episodes: Int?,
    @SerializedName("aired") val aired: AiredDateDto,
    @SerializedName("score") val score: Int?,
    @SerializedName("synopsis") val synopsis: String?,
    @SerializedName("genres") val genres: List<GenreDto>
)

data class AnimeImagesDto(
    @SerializedName("jpg") val jpg: JpgImageDto
)

data class JpgImageDto(
    @SerializedName("image_url") val imageUrl: String
)

data class AiredDateDto(
    @SerializedName("from") val from: String?
)

data class GenreDto(
    @SerializedName("name") val name: String
)