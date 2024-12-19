package app.vercel.lcsanimelist.data.mapper

import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity
import app.vercel.lcsanimelist.data.network.dto.AnimeSearchHintDto
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint

fun AnimeSearchHintEntity.toDomainModel(): AnimeSearchHint {
    return AnimeSearchHint(
        query = query,
        isFromHistory = true
    )
}

fun AnimeSearchHintDto.toDomainModel(): AnimeSearchHint {
    return AnimeSearchHint(
        query = title,
        isFromHistory = false
    )
}