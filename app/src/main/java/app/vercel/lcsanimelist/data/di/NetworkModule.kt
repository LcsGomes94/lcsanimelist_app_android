package app.vercel.lcsanimelist.data.di

import app.vercel.lcsanimelist.data.remote.service.AnimeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideAnimeService(retrofit: Retrofit): AnimeService {
    return retrofit.create(AnimeService::class.java)
}