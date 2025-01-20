package app.vercel.lcsanimelist.domain.model

data class LocalQueryParameters(
    val personalStage: PersonalStage = PersonalStage.WATCH,
    val limit: Int = 12,
    val search: String? = null,
    val genres: List<AnimeGenre> = emptyList(),
    val orderBy: OrderBy = if (personalStage == PersonalStage.WATCH) OrderBy.SCORE else OrderBy.TIER,
)
