package app.vercel.lcsanimelist.presentation.ui.seasonal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.OrderBy
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.usecase.AnimeUseCases
import app.vercel.lcsanimelist.presentation.ui.common.component.ScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SeasonalViewModel(private val useCases: AnimeUseCases) : ViewModel(), ScreenViewModel {

    private val _selectedSeason = MutableStateFlow(AnimeSeason.now())
    override val selectedSeason = _selectedSeason.asStateFlow()

    override val availableSeasons = flow {
        emit(useCases.getAvailableSeasons())
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    private val _animeUpdates = MutableStateFlow<Map<Int, Anime>>(emptyMap())

    @OptIn(ExperimentalCoroutinesApi::class)
    private val _animePagingData = _selectedSeason
        .flatMapLatest { useCases.getSeasonalAnimeList(it) }
        .cachedIn(viewModelScope)

    val updatedAnimePagingData = _animePagingData.combine(_animeUpdates) { paging, updates ->
        paging.map { anime ->
            updates[anime.id] ?: anime
        }
    }.cachedIn(viewModelScope)

    override fun updateSelectedSeason(newSeason: AnimeSeason) {
        _selectedSeason.value = newSeason
    }

    private fun updatePagingDataState(anime: Anime) {
        _animeUpdates.update { current ->
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

    override val animeSearchHints: StateFlow<List<AnimeSearchHint>> = MutableStateFlow(emptyList())
    override fun addToSearchHistory(searchQuery: String) {}
    override fun updateSearchHintQuery(newSearchHintQuery: String?) {}
    override val query: StateFlow<RemoteQueryParameters> = MutableStateFlow(RemoteQueryParameters())
    override fun updateQuery(newSearchQuery: String?, newGenreFilter: List<AnimeGenre>?, newOrderBy: OrderBy) {}

}