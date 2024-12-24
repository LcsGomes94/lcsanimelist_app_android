package app.vercel.lcsanimelist.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime WHERE id = :id")
    suspend fun getFavoriteById(id: Int): AnimeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(anime: AnimeEntity)

    @Update
    suspend fun updateFavorite(anime: AnimeEntity): Int

    @Delete
    suspend fun deleteFavorite(anime: AnimeEntity): Int

    @Query("SELECT * FROM anime")
    suspend fun getAllFavorites(): List<AnimeEntity>

    @Query("""
        SELECT * FROM anime
        WHERE (:search IS NULL OR LOWER(`title`) LIKE '%' || LOWER(:search) || '%')
        ORDER BY
            CASE WHEN :orderBy = 'SCORE' THEN score END DESC,
            CASE WHEN :orderBy = 'TITLE' THEN title END ASC,
            CASE WHEN :orderBy = 'TIER' THEN personalTier END DESC, score DESC
        LIMIT :limit OFFSET :offset
    """)
    suspend fun getPagedFavorites(
        search: String?,
        orderBy: String,
        limit: Int,
        offset: Int
    ): List<AnimeEntity>
}