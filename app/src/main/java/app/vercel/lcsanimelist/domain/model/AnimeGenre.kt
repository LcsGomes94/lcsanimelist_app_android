package app.vercel.lcsanimelist.domain.model

enum class AnimeGenre(val id: Int, val displayName: String) {
    ACTION(1, "Action"),
    ADVENTURE(2, "Adventure"),
    AVANT_GARDE(5, "Avant Garde"),
    AWARD_WINNING(46, "Award Winning"),
    BOYS_LOVE(28, "Boys Love"),
    COMEDY(4, "Comedy"),
    DRAMA(8, "Drama"),
    ECCHI(9, "Ecchi"),
    EROTICA(49, "Erotica"),
    FANTASY(10, "Fantasy"),
    GIRLS_LOVE(26, "Girls Love"),
    GOURMET(47, "Gourmet"),
    HENTAI(12, "Hentai"),
    HORROR(14, "Horror"),
    MYSTERY(7, "Mystery"),
    ROMANCE(22, "Romance"),
    SCI_FI(24, "Sci-Fi"),
    SLICE_OF_LIFE(36, "Slice of Life"),
    SPORTS(30, "Sports"),
    SUPERNATURAL(37, "Supernatural"),
    SUSPENSE(41, "Suspense");

    companion object {
        fun fromId(id: Int): AnimeGenre? = entries.find { it.id == id }
        fun fromName(name: String): AnimeGenre? = entries.find { it.displayName.lowercase() == name.lowercase() }
    }
}