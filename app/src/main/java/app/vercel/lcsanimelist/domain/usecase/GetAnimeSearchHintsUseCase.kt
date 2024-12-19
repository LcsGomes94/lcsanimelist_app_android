package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.QueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAnimeSearchHintsUseCase(private val repository: AnimeRepository) {
    operator fun invoke(query: QueryParameters = QueryParameters()): Flow<List<AnimeSearchHint>> {
        return repository.getAnimeSearchHints(query)
            .map { searchHints ->
                searchHints.take(query.limit)
            }
    }
}