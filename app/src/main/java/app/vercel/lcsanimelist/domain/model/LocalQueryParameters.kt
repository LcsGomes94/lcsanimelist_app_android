package app.vercel.lcsanimelist.domain.model

data class LocalQueryParameters(
    val personalStage: PersonalStage = PersonalStage.WATCH,
    val limit: Int = 12,
    val search: String? = null,
    val genres: List<AnimeGenre> = emptyList(),
    val orderBy: LocalOrderBy = if (personalStage == PersonalStage.WATCH) LocalOrderBy.SCORE else LocalOrderBy.TIER,
)

enum class LocalOrderBy { SCORE, TITLE, TIER }
