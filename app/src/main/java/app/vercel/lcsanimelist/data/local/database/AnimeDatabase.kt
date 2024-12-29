package app.vercel.lcsanimelist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.vercel.lcsanimelist.data.local.converter.EnumConverter
import app.vercel.lcsanimelist.data.local.converter.LocalDateConverter
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.dao.AnimeSearchHistoryDao
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.AnimeGenreCrossRefEntity
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity
import app.vercel.lcsanimelist.data.local.entity.GenreEntity

@Database(
    entities = [
        AnimeEntity::class,
        GenreEntity::class,
        AnimeGenreCrossRefEntity::class,
        AnimeSearchHintEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateConverter::class, EnumConverter::class)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
    abstract fun animeSearchHintDao(): AnimeSearchHistoryDao
}