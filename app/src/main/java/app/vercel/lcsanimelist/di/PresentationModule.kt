package app.vercel.lcsanimelist.di

import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.LcsAnimeListBottomNavBarViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModalViewModel
import app.vercel.lcsanimelist.presentation.ui.home.HomeViewModel
import app.vercel.lcsanimelist.presentation.ui.seasonal.SeasonalViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SeasonalViewModel(get()) }
    viewModel { EditModalViewModel() }
    viewModel { SearchFilterViewModel() }
    viewModel { LcsAnimeListBottomNavBarViewModel() }
}