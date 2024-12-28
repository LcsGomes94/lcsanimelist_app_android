package app.vercel.lcsanimelist.di

import app.vercel.lcsanimelist.domain.usecase.AddFavoriteAnimeUseCase
import app.vercel.lcsanimelist.domain.usecase.AddToSearchHistoryUseCase
import app.vercel.lcsanimelist.domain.usecase.AnimeUseCases
import app.vercel.lcsanimelist.domain.usecase.GetAnimeListUseCase
import app.vercel.lcsanimelist.domain.usecase.GetAnimeSearchHintsUseCase
import app.vercel.lcsanimelist.domain.usecase.GetAvailableAnimeSeasonsUseCase
import app.vercel.lcsanimelist.domain.usecase.GetFavoriteAnimeListUseCase
import app.vercel.lcsanimelist.domain.usecase.GetFavoriteSearchHintsUseCase
import app.vercel.lcsanimelist.domain.usecase.GetSeasonalAnimeListUseCase
import app.vercel.lcsanimelist.domain.usecase.RemoveFavoriteAnimeUseCase
import app.vercel.lcsanimelist.domain.usecase.UpdateFavoriteAnimeUseCase
import org.koin.dsl.module

val domainModule = module {
    // Use Cases
    single { GetAnimeListUseCase(get()) }

    single { GetFavoriteAnimeListUseCase(get()) }
    single { UpdateFavoriteAnimeUseCase(get()) }
    single { AddFavoriteAnimeUseCase(get()) }
    single { RemoveFavoriteAnimeUseCase(get()) }

    single { GetAnimeSearchHintsUseCase(get()) }
    single { AddToSearchHistoryUseCase(get()) }
    single { GetFavoriteSearchHintsUseCase(get()) }

    single { GetAvailableAnimeSeasonsUseCase(get()) }
    single { GetSeasonalAnimeListUseCase(get()) }

    single { AnimeUseCases(get(), get(), get(), get(), get(), get(), get(), get(), get(), get()) }
}