package app.vercel.lcsanimelist.domain.model

data class QueryParameters(
    val limit: Int = 12,
    val search: String? = null,
    val genres: List<AnimeGenre>? = null,
    val orderBy: OrderBy = OrderBy.SCORE,
    val sort: SortOrder = if (orderBy == OrderBy.SCORE) SortOrder.DESC else SortOrder.ASC,
    val page: Int = 1
)

enum class OrderBy { SCORE, TITLE }

enum class SortOrder { ASC, DESC }