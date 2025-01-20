package app.vercel.lcsanimelist.domain.model

enum class OrderBy(val displayName: String) {
    SCORE("Score"),
    TITLE("Title"),
    TIER("Tier")
}