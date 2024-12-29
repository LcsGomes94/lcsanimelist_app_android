package app.vercel.lcsanimelist.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.AnimeGenreCrossRefEntity
import app.vercel.lcsanimelist.data.local.entity.GenreEntity
import app.vercel.lcsanimelist.data.local.entity.relation.AnimeWithGenres

@Dao
interface AnimeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnime(anime: AnimeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenre(genre: GenreEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimeGenreCrossRefs(crossRefs: List<AnimeGenreCrossRefEntity>)

    @Transaction
    suspend fun insertFavorite(animeWithGenres: AnimeWithGenres) {
        insertAnime(animeWithGenres.anime)

        animeWithGenres.genres.forEach { insertGenre(it) }

        animeWithGenres.genres.map { genre ->
            AnimeGenreCrossRefEntity(animeId = animeWithGenres.anime.id, genreId = genre.id)
        }.let { insertAnimeGenreCrossRefs(it) }
    }

    @Query("SELECT * FROM anime WHERE id = :id")
    suspend fun getAnimeById(id: Int): AnimeEntity?

    @Transaction
    @Query("""
        SELECT * FROM anime
        WHERE (personalStage = :personalStage)
            AND (:search IS NULL OR LOWER(`title`) LIKE '%' || LOWER(:search) || '%')
            AND (
                :genreCount = 0 OR id IN (
                    SELECT animeId
                    FROM anime_genre_cross_ref
                    WHERE genreId IN (:genreIds)
                    GROUP BY animeId
                    HAVING COUNT(DISTINCT genreId) = :genreCount
                )
            )
        ORDER BY
            CASE WHEN :orderBy = 'SCORE' THEN score END DESC,
            CASE WHEN :orderBy = 'TITLE' THEN title END ASC,
            CASE WHEN :orderBy = 'TIER' THEN personalTier END DESC, score DESC
        LIMIT :limit OFFSET :offset
    """)
    suspend fun getPagedFavorites(
        personalStage: Int,
        search: String?,
        orderBy: String,
        genreIds: List<Int>,
        genreCount: Int,
        limit: Int,
        offset: Int
    ): List<AnimeWithGenres>

    @Query("""
        SELECT title FROM anime
        WHERE (personalStage = :personalStage)
            AND (:search IS NULL OR LOWER(`title`) LIKE '%' || LOWER(:search) || '%')
            AND (
                :genreCount = 0 OR id IN (
                    SELECT animeId
                    FROM anime_genre_cross_ref
                    WHERE genreId IN (:genreIds)
                    GROUP BY animeId
                    HAVING COUNT(DISTINCT genreId) = :genreCount
                )
            )
        ORDER BY
            CASE WHEN :orderBy = 'SCORE' THEN score END DESC,
            CASE WHEN :orderBy = 'TITLE' THEN title END ASC,
            CASE WHEN :orderBy = 'TIER' THEN personalTier END DESC, score DESC
        LIMIT :limit
    """)
    suspend fun getFavoriteAnimeTitles(
        personalStage: Int,
        search: String?,
        orderBy: String,
        genreIds: List<Int>,
        genreCount: Int,
        limit: Int,
    ): List<String>

    @Update
    suspend fun updateFavorite(anime: AnimeEntity): Int

    @Delete
    suspend fun deleteFavorite(anime: AnimeEntity): Int
}