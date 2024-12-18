package app.vercel.lcsanimelist.domain.model

data class AnimeSearchHint(
    val query: String,
    val isFromHistory: Boolean
)