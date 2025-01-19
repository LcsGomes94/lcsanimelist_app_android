package app.vercel.lcsanimelist.domain.model

enum class PersonalStage(val displayName: String) {
    WATCH("Watch List"),
    FINISHED("Finished"),
    DROPPED("Dropped")
}