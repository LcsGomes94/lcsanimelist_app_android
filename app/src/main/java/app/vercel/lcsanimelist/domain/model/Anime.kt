package app.vercel.lcsanimelist.domain.model

import java.time.LocalDate

data class Anime(
    val id: Int,
    val title: String,
    val release: LocalDate?,
    val episodes: Int?,
    val genres: List<String>,
    val imageUrl: String,
    val synopsis: String?,
    val personalNote: String?,
    val personalStage: PersonalStage?,
    val score: Double?,
    val personalTier: PersonalTier?
)

enum class PersonalStage { WATCH, FINISHED, DROPPED }

enum class PersonalTier { SS, S, A, B, C, D, E }