package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.lifecycle.ViewModel
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.OrderBy
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchFilterViewModel() : ViewModel() {
    private val _activeScreenViewModel = MutableStateFlow<ScreenViewModel?>(null)
    private val _activeScreen = MutableStateFlow<ScreenType?>(null)
    val activeScreen = _activeScreen.asStateFlow()

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
            _newOrderBy.value = viewModel.query.value.orderBy
            _newGenreFilter.value = viewModel.query.value.genres
            _newSearchQuery.value = viewModel.query.value.search.orEmpty()
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
    }

    fun onConfirmButtonClick() {
        _activeScreenViewModel.value?.let { viewModel ->
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