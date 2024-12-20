package app.vercel.lcsanimelist.domain.model

enum class Season(val displayName: String) {
    WINTER("Winter"),
    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall");

    companion object {
        fun fromName(name: String): Season? = entries.find { it.displayName.lowercase() == name.lowercase() }
    }
}