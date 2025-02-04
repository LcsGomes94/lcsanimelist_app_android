package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.remote.dto.AnimeSeasonDto
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.Season

fun List<AnimeSeasonDto>.toDomainModel(): List<AnimeSeason> {
    return this.flatMap { dto ->
        dto.seasons.reversed().mapNotNull { seasonName ->
            Season.fromName(seasonName)?.let { season ->
                AnimeSeason(year = dto.year, season = season)
            }
        }
    }
}