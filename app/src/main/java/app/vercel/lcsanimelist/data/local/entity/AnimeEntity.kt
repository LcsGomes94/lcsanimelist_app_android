package app.vercel.lcsanimelist.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import java.time.LocalDate

@Entity(
    tableName = "anime",
    indices = [
        Index(value = ["title"]),
        Index(value = ["score"]),
        Index(value = ["personalTier"])
    ]
)
data class AnimeEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val release: LocalDate?,
    val episodes: Int?,
    val imageUrl: String,
    val synopsis: String?,
    val personalNote: String?,
    val personalStage: PersonalStage,
    val score: Double?,
    val personalTier: PersonalTier?
)