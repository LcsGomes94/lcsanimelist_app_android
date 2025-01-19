package app.vercel.lcsanimelist.domain.usecase

import androidx.paging.PagingData
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.LocalQueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteAnimeListUseCase(private val repository: AnimeRepository) {
    operator fun invoke(query: LocalQueryParameters): Flow<PagingData<Anime>> {
        val treatedQuery = query.copy(search = query.search?.trim())
        return repository.getFavoriteAnimeList(treatedQuery)
    }
}