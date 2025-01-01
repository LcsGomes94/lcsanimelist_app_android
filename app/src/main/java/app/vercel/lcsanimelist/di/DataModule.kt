package app.vercel.lcsanimelist.di

import app.vercel.lcsanimelist.data.local.provideAnimeDao
import app.vercel.lcsanimelist.data.local.provideAnimeSearchHintDao
import app.vercel.lcsanimelist.data.remote.provideAnimeService
import app.vercel.lcsanimelist.data.local.provideDatabase
import app.vercel.lcsanimelist.data.remote.provideRetrofit
import app.vercel.lcsanimelist.data.repository.AnimeRepositoryImpl
import app.vercel.lcsanimelist.domain.repository.AnimeRepository
import org.koin.dsl.module

val dataModule = module {
    // Retrofit
    single { provideRetrofit() }
    single { provideAnimeService(get()) }

    // Room
    single { provideDatabase(get()) }
    single { provideAnimeDao(get()) }
    single { provideAnimeSearchHintDao(get()) }

    // Repository
    single<AnimeRepository> { AnimeRepositoryImpl(get(), get(), get()) }
}