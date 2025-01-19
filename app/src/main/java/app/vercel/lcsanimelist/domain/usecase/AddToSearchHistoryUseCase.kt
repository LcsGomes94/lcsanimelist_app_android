package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.repository.AnimeRepository

class AddToSearchHistoryUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(searchQuery: String) {
        val treatedSearchQuery = searchQuery.trim()

        if (treatedSearchQuery.length < 3) return

        repository.addToSearchHistory(treatedSearchQuery)
    }
}