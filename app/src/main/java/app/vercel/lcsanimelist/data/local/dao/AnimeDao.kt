package app.vercel.lcsanimelist.data.local.dao

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
}