package app.vercel.lcsanimelist.domain.usecase

import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PaginatedResult
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetAnimeListUseCase(private val repository: AnimeRepository) {
    operator fun invoke(query: RemoteQueryParameters = RemoteQueryParameters()): Flow<PaginatedResult<Anime>> {
        return repository.getAnimeList(query)
    }
}