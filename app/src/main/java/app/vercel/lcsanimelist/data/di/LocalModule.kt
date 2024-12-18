package app.vercel.lcsanimelist.data.di

import android.content.Context
import androidx.room.Room
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.dao.AnimeSearchHintDao
import app.vercel.lcsanimelist.data.local.database.AnimeDatabase

fun provideDatabase(context: Context): AnimeDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        AnimeDatabase::class.java,
        "anime_db"
    ).build()
}

fun provideAnimeDao(database: AnimeDatabase): AnimeDao {
    return database.animeDao()
}

fun provideAnimeSearchHintDao(database: AnimeDatabase): AnimeSearchHintDao {
    return database.animeSearchHintDao()
}