package app.vercel.lcsanimelist.di

import app.vercel.lcsanimelist.data.di.provideAnimeDao
import app.vercel.lcsanimelist.data.di.provideAnimeSearchHintDao
import app.vercel.lcsanimelist.data.di.provideAnimeService
import app.vercel.lcsanimelist.data.di.provideDatabase
import app.vercel.lcsanimelist.data.di.provideRetrofit
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