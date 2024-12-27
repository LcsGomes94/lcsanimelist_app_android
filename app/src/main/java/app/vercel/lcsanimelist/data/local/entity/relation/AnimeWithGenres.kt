package app.vercel.lcsanimelist.data.local.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.AnimeGenreCrossRefEntity
import app.vercel.lcsanimelist.data.local.entity.GenreEntity

data class AnimeWithGenres(
    @Embedded val anime: AnimeEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = AnimeGenreCrossRefEntity::class,
            parentColumn = "animeId",
            entityColumn = "genreId"
        )
    )
    val genres: List<GenreEntity>
)
