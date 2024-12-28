package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.LocalQueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteSearchHintsUseCase(private val repository: AnimeRepository) {
    operator fun invoke(query: LocalQueryParameters): Flow<List<AnimeSearchHint>> {
        return repository.getFavoriteSearchHints(query)
    }
}