package app.vercel.lcsanimelist.util.extension

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun LocalDate?.toAnimeReleaseString(): String {
    if (this == null) return "Unknown"
    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.US)
    return this.format(formatter)
}