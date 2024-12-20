package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.repository.AnimeRepository

class GetAvailableAnimeSeasonsUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(): List<AnimeSeason> {
        return repository.getAvailableSeasons().take(11)
    }
}