package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.network.dto.AnimeDto
import app.vercel.lcsanimelist.domain.model.Anime

fun AnimeDto.toDomainModel(favorite: AnimeEntity?): Anime {
    return Anime(
        id = id,
        title = title,
        release = aired.from.toLocalDateOrNull(),
        episodes = episodes,
        genres = genres.map { it.name },
        imageUrl = images.jpg.imageUrl,
        synopsis = synopsis,
        personalNote = favorite?.personalNote,
        personalStage = favorite?.personalStage,
        score = score,
        personalTier = favorite?.personalTier
    )
}