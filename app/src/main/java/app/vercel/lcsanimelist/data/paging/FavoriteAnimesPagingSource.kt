package app.vercel.lcsanimelist.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.mapper.toDomainModel
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.LocalQueryParameters

class FavoriteAnimesPagingSource(
    private val animeDao: AnimeDao,
    private val query: LocalQueryParameters
) : PagingSource<Int, Anime>() {

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        return try {
            val page = params.key ?: 0
            val pageSize = params.loadSize
            val offset = page * pageSize

            val animeEntities = animeDao.getPagedFavorites(
                query.personalStage.ordinal,
                query.search,
                query.orderBy.name,
                query.genres.map { it.id },
                query.genres.size,
                pageSize,
                offset
            )
            val animeList = animeEntities.map { it.toDomainModel() }

            LoadResult.Page(
                data = animeList,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (animeEntities.size < pageSize) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}