package app.vercel.lcsanimelist.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "anime_genre_cross_ref",
    primaryKeys = ["animeId", "genreId"],
    foreignKeys = [
        ForeignKey(
            entity = AnimeEntity::class,
            parentColumns = ["id"],
            childColumns = ["animeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = GenreEntity::class,
            parentColumns = ["id"],
            childColumns = ["genreId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["animeId"]), Index(value = ["genreId"])]
)
data class AnimeGenreCrossRefEntity(
    val animeId: Int,
    val genreId: Int
)
