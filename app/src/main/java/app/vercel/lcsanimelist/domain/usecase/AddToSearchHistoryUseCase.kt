package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.repository.AnimeRepository

class AddToSearchHistoryUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(searchQuery: String) {
        if (searchQuery.trim().length < 3) return

        repository.addToSearchHistory(searchQuery.trim())
    }
}