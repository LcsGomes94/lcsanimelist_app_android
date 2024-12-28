package app.vercel.lcsanimelist.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity

@Dao
interface AnimeSearchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoHistory(animeSearchHint: AnimeSearchHintEntity)

    @Query("SELECT * FROM search_history WHERE LOWER(`query`) LIKE '%' || LOWER(:searchQuery) || '%' ORDER BY timestamp DESC LIMIT :limit")
    suspend fun findInHistory(searchQuery: String, limit: Int): List<AnimeSearchHintEntity>

    @Query("SELECT * FROM search_history ORDER BY timestamp DESC LIMIT :limit")
    suspend fun getRecentHistory(limit: Int): List<AnimeSearchHintEntity>
}