package app.vercel.lcsanimelist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.vercel.lcsanimelist.data.local.converter.EnumConverter
import app.vercel.lcsanimelist.data.local.converter.GenreConverter
import app.vercel.lcsanimelist.data.local.converter.LocalDateConverter
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.dao.AnimeSearchHintDao
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity
import app.vercel.lcsanimelist.data.local.entity.AnimeSearchHintEntity

@Database(entities = [AnimeEntity::class, AnimeSearchHintEntity::class], version = 1)
@TypeConverters(GenreConverter::class, LocalDateConverter::class, EnumConverter::class)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
    abstract fun animeSearchHintDao(): AnimeSearchHintDao
}