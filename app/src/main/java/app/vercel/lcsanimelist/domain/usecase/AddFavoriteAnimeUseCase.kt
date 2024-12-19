package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.repository.AnimeRepository

class AddFavoriteAnimeUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(anime: Anime) {
        return repository.addFavorite(anime)
    }
}