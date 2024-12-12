package app.vercel.lcsanimelist.data.di

import android.content.Context
import androidx.room.Room
import app.vercel.lcsanimelist.data.local.dao.AnimeDao
import app.vercel.lcsanimelist.data.local.database.FavoriteAnimeDatabase

fun provideDatabase(context: Context): FavoriteAnimeDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        FavoriteAnimeDatabase::class.java,
        "favorite_anime_db"
    ).build()
}

fun provideAnimeDao(database: FavoriteAnimeDatabase): AnimeDao {
    return database.animeDao()
}