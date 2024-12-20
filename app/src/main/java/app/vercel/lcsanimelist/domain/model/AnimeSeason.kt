package app.vercel.lcsanimelist.domain.model

data class AnimeSeason(
    val year: Int,
    val season: Season,
) {
    override fun toString() = "$year - ${season.displayName}"
}
