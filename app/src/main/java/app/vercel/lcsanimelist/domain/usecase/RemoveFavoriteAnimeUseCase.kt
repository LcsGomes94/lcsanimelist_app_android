package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.repository.AnimeRepository

class RemoveFavoriteAnimeUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(anime: Anime): Boolean {
        return repository.removeFavorite(anime)
    }
}