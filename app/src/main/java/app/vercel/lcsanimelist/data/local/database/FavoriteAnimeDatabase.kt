package app.vercel.lcsanimelist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.vercel.lcsanimelist.data.local.converter.EnumConverter
import app.vercel.lcsanimelist.data.local.converter.GenreConverter
import app.vercel.lcsanimelist.data.local.converter.LocalDateConverter
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.entity.AnimeEntity

@Database(entities = [AnimeEntity::class], version = 1)
@TypeConverters(GenreConverter::class, LocalDateConverter::class, EnumConverter::class)
abstract class FavoriteAnimeDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
}