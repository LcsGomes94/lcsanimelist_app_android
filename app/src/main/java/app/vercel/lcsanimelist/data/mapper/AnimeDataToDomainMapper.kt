package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.relation.AnimeWithGenres
import app.vercel.lcsanimelist.data.remote.dto.AnimeDto
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.util.extension.toLocalDateOrNull

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

fun AnimeWithGenres.toDomainModel(): Anime {
    return Anime(
        id = anime.id,
        title = anime.title,
        release = anime.release,
        episodes = anime.episodes,
        genres = genres.map { it.name },
        imageUrl = anime.imageUrl,
        synopsis = anime.synopsis,
        personalNote = anime.personalNote,
        personalStage = anime.personalStage,
        score = anime.score,
        personalTier = anime.personalTier,
    )
}