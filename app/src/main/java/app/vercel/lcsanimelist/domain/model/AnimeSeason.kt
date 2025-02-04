package app.vercel.lcsanimelist.domain.model

import java.time.YearMonth

data class AnimeSeason(
    val year: Int,
    val season: Season,
) {
    override fun toString() = "$year - ${season.displayName}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AnimeSeason) return false
        return (year == other.year && season == other.season)
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + year
        result = 31 * result + season.hashCode()
        return result
    }

    companion object {
        fun now(): AnimeSeason {
            val now = YearMonth.now()
            val season = when(now.monthValue) {
                in 1..3 -> Season.WINTER
                in 4..6 -> Season.SPRING
                in 7..9 -> Season.SUMMER
                else -> Season.FALL
            }

            return AnimeSeason(now.year, season)
        }
    }
}
