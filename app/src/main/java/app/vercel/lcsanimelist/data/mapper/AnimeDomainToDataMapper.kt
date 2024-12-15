package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage

fun Anime.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        title = title,
        release = release,
        episodes = episodes,
        genres = genres,
        imageUrl = imageUrl,
        synopsis = synopsis,
        personalNote = personalNote,
        personalStage = personalStage ?: PersonalStage.WATCH,
        score = score,
        personalTier = personalTier
    )
}