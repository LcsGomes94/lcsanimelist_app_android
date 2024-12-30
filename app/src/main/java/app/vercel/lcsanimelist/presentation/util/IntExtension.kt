package app.vercel.lcsanimelist.presentation.util

fun Int?.toAnimeEpisodesString(): String {
    if (this == null) return "Unknown"
    val episodeString = when {
        this > 1 -> "$this episodes"
        else -> "$this episode"
    }
    return episodeString
}