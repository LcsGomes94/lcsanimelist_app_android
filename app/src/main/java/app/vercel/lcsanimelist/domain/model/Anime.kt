package app.vercel.lcsanimelist.domain.model

import java.time.LocalDate

data class Anime(
    val id: Int = 0,
    val title: String = "Hunter x Hunter",
    val release: LocalDate? = LocalDate.of(1994, 2, 7),
    val episodes: Int? = 1,
    val genres: List<String> = listOf("Action", "Adventure", "Fantasy"),
    val imageUrl: String = "https://cdn.myanimelist.net/images/anime/1337/99013.jpg",
    val synopsis: String? = "Best anime ever made!",
    val personalNote: String? = null,
    val personalStage: PersonalStage? = null,
    val score: Double? = 10.0,
    val personalTier: PersonalTier? = null
)