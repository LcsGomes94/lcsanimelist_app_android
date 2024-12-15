package app.vercel.lcsanimelist.data.mapper

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String?.toLocalDateOrNull(): LocalDate? {
    if (this.isNullOrBlank()) return null

    return try {
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        LocalDate.parse(this, formatter)
    } catch(e: DateTimeParseException) {
        null
    }
}