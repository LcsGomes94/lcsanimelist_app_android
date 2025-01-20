package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.OrderBy
import app.vercel.lcsanimelist.domain.usecase.AddToSearchHistoryUseCase
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SearchFilterViewModel() : ViewModel() {

    private val _activeScreenViewModel = MutableStateFlow<ScreenViewModel?>(null)
    private val _activeScreen = MutableStateFlow<ScreenType?>(null)
    val activeScreen = _activeScreen.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val animeSearchHints = _activeScreenViewModel
        .filterNotNull()
        .flatMapLatest { it.animeSearchHints }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _isFilterModalVisible = MutableStateFlow(false)
    val isFilterModalVisible = _isFilterModalVisible.asStateFlow()
    private val _isSearchModalVisible = MutableStateFlow(false)
    val isSearchModalVisible = _isSearchModalVisible.asStateFlow()

    private val _newSearchQuery = MutableStateFlow<String>("")
    val newSearchQuery = _newSearchQuery.asStateFlow()
    private val _newGenreFilter = MutableStateFlow<List<AnimeGenre>?>(null)
    val genreFilter = _newGenreFilter.asStateFlow()
    private val _newOrderBy = MutableStateFlow<OrderBy>(OrderBy.SCORE)
    val newOrderBy = _newOrderBy.asStateFlow()

    private fun syncQuery() {
        _activeScreenViewModel.value?.let { viewModel ->
            _newSearchQuery.value = viewModel.query.value.search.orEmpty()
            _newGenreFilter.value = viewModel.query.value.genres
            _newOrderBy.value = viewModel.query.value.orderBy
            viewModel.updateSearchHintQuery(_newSearchQuery.value)
        }
    }

    fun setActiveScreen(screen: ScreenType, viewModel: ScreenViewModel) {
        _activeScreenViewModel.value = viewModel
        _activeScreen.value = screen
    }

    fun onFilterModalOpen() {
        syncQuery()
        _isFilterModalVisible.value = true
    }

    fun onFilterModalClose() {
        _isFilterModalVisible.value = false
    }

    fun onSearchModalOpen() {
        syncQuery()
        _isSearchModalVisible.value = true
    }

    fun onSearchModalClose() {
        _isSearchModalVisible.value = false
    }

    fun onOrderByChange(newOrderBy: OrderBy) {
        _newOrderBy.value = newOrderBy
    }

    fun onGenreFilterChange(newGenreFilter: List<AnimeGenre>?) {
        _newGenreFilter.value = newGenreFilter
    }

    fun onSearchQueryChange(newSearchQuery: String) {
        _newSearchQuery.value = newSearchQuery
        _activeScreenViewModel.value?.updateSearchHintQuery(newSearchQuery)
    }

    fun onConfirmButtonClick() {
        _activeScreenViewModel.value?.let { viewModel ->
            viewModel.addToSearchHistory(_newSearchQuery.value)
            viewModel.updateQuery(
                newSearchQuery = _newSearchQuery.value.ifBlank { null },
                newGenreFilter = _newGenreFilter.value,
                newOrderBy = _newOrderBy.value,
            )
            onFilterModalClose()
            onSearchModalClose()
        }
    }

}