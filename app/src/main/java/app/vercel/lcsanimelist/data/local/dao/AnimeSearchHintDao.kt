package app.vercel.lcsanimelist.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity

@Dao
interface AnimeSearchHintDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInHistory(animeSearchHint: AnimeSearchHintEntity)

    @Query("SELECT * FROM search_history WHERE LOWER(`query`) LIKE '%' || LOWER(:searchQuery) || '%' ORDER BY timestamp DESC")
    suspend fun findInHistory(searchQuery: String): List<AnimeSearchHintEntity>
}