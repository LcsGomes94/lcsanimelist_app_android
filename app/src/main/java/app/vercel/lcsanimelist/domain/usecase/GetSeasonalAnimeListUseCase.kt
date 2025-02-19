package app.vercel.lcsanimelist.domain.usecase

import androidx.paging.PagingData
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.OrderBy
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetSeasonalAnimeListUseCase(private val repository: AnimeRepository) {
    operator fun invoke(season: AnimeSeason, query: RemoteQueryParameters = RemoteQueryParameters()): Flow<PagingData<Anime>> {
        val treatedQuery = query.copy(
            search = query.search?.trim(),
            orderBy = when {
                query.orderBy == OrderBy.TIER -> OrderBy.SCORE
                else -> query.orderBy
            }
        )
        return repository.getSeasonalAnimeList(season, treatedQuery)
    }
}