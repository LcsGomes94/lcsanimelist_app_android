package app.vercel.lcsanimelist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_history")
data class AnimeSearchHintEntity(
    @PrimaryKey val query: String,
    val timestamp: Long = System.currentTimeMillis()
)
