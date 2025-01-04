package app.vercel.lcsanimelist.data.paging

import android.database.sqlite.SQLiteException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.mapper.toAnimeEntity
import app.vercel.lcsanimelist.data.mapper.toDomainModel
import app.vercel.lcsanimelist.data.mapper.toQueryMap
import app.vercel.lcsanimelist.data.remote.service.AnimeService
import app.vercel.lcsanimelist.domain.exception.RepositoryException
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException

class SeasonalAnimesPagingSource(
    private val animeService: AnimeService,
    private val animeDao: AnimeDao,
    private val season: AnimeSeason,
    private val query: RemoteQueryParameters,
) : PagingSource<Int, Anime>() {

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> = coroutineScope {
        try {
            val page = params.key ?: 1
            val responseDto = animeService.getSeasonalAnimeList(season.year, season.season.displayName, query.toQueryMap(), page)
            val animeList = responseDto.data.map { animeDto ->
                async {
                    val favorite = animeDao.getAnimeById(animeDto.id)
                    animeDto.toDomainModel(favorite).also { anime ->
                        favorite?.let { animeDao.updateFavorite(anime.toAnimeEntity()) }
                    }
                }
            }.awaitAll()

            LoadResult.Page(
                data = animeList,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (responseDto.pagination.hasNextPage) page + 1 else null
            )
        } catch (e: SQLiteException) {
            LoadResult.Error(RepositoryException.DatabaseException("Failed to get favorite anime.\n" + e.message, e))
        } catch (e: HttpException) {
            LoadResult.Error(RepositoryException.NetworkException("Failed to get seasonal anime list.\n" + e.message, e))
        } catch (e: Exception) {
            LoadResult.Error(RepositoryException.UnknownException("Unexpected error occurred.", e))
        }
    }

}