package app.vercel.lcsanimelist.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.usecase.AnimeUseCases
import app.vercel.lcsanimelist.presentation.ui.common.component.ScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val useCases: AnimeUseCases) : ViewModel(), ScreenViewModel {

    private val _query = MutableStateFlow(RemoteQueryParameters())
    override val query = _query.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val animePagingData = query
        .flatMapLatest { useCases.getAnimeList(it) }
        .cachedIn(viewModelScope)

    private val animeUpdates = MutableStateFlow<Map<Int, Anime>>(emptyMap())

    val updatedAnimePagingData = animePagingData.combine(animeUpdates) { paging, updates ->
        paging.map { anime ->
            updates[anime.id] ?: anime
        }
    }.cachedIn(viewModelScope)

    override fun updateQuery(newQuery: RemoteQueryParameters) {
        _query.value = newQuery
    }

    private fun updatePagingDataState(anime: Anime) {
        animeUpdates.update { current ->
            current + (anime.id to anime)
        }
    }

    private fun addFavorite(anime: Anime) {
        viewModelScope.launch {
            updatePagingDataState(anime)
            useCases.addFavorite(anime)
        }
    }

    fun removeFavorite(anime: Anime) {
        viewModelScope.launch {
            val updatedAnime = anime.copy(
                personalStage = null,
                personalTier = null,
                personalNote = null
            )
            updatePagingDataState(updatedAnime)
            useCases.removeFavorite(anime)
        }
    }

    fun updateFavorite(anime: Anime) {
        viewModelScope.launch {
            updatePagingDataState(anime)
            useCases.updateFavorite(anime)
        }
    }

    fun onFavoriteToggle(anime: Anime) {
        val isFavorite = anime.personalStage != null
        val updatedAnime = anime.copy(personalStage = if (isFavorite) null else PersonalStage.WATCH)

        if (isFavorite) {
            removeFavorite(updatedAnime)
            return
        }

        addFavorite(updatedAnime)
    }

}