package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.remote.dto.AnimeDto
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

fun AnimeEntity.toDomainModel(): Anime {
    return Anime(
        id = id,
        title = title,
        release = release,
        episodes = episodes,
        genres = genres,
        imageUrl = imageUrl,
        synopsis = synopsis,
        personalNote = personalNote,
        personalStage = personalStage,
        score = score,
        personalTier = personalTier
    )
}