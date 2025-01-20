package app.vercel.lcsanimelist.domain.model

data class RemoteQueryParameters(
    val limit: Int = 12,
    val search: String? = null,
    val genres: List<AnimeGenre>? = null,
    val orderBy: OrderBy = OrderBy.SCORE,
    val sort: SortOrder = if (orderBy == OrderBy.SCORE) SortOrder.DESC else SortOrder.ASC
)

enum class SortOrder { ASC, DESC }