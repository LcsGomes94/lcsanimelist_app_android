package app.vercel.lcsanimelist.domain.model

data class RemoteQueryParameters(
    val limit: Int = 12,
    val search: String? = null,
    val genres: List<AnimeGenre>? = null,
    val orderBy: RemoteOrderBy = RemoteOrderBy.SCORE,
    val sort: SortOrder = if (orderBy == RemoteOrderBy.SCORE) SortOrder.DESC else SortOrder.ASC
)

enum class RemoteOrderBy(val displayName: String) {
    SCORE("Score"),
    TITLE("Title")
}

enum class SortOrder { ASC, DESC }