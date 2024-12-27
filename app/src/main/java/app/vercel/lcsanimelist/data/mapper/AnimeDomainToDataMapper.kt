package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.GenreEntity
import app.vercel.lcsanimelist.data.local.entity.relation.AnimeWithGenres
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.PersonalStage

fun Anime.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        title = title,
        release = release,
        episodes = episodes,
        imageUrl = imageUrl,
        synopsis = synopsis,
        personalNote = personalNote,
        personalStage = personalStage ?: PersonalStage.WATCH,
        score = score,
        personalTier = personalTier
    )
}

fun Anime.toAnimeWithGenres(): AnimeWithGenres {
    return AnimeWithGenres(
        anime = toAnimeEntity(),
        genres = genres.mapNotNull { name ->
            AnimeGenre.fromName(name)?.let { animeGenre ->
                GenreEntity(
                    id = animeGenre.id,
                    name = animeGenre.displayName
                )
            }
        }
    )
}