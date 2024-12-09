package app.vercel.lcsanimelist.domain.model

data class PaginatedResult<T>(
    val items: List<T>,
    val hasNextPage: Boolean
)