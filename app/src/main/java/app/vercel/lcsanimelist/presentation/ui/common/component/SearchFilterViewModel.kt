package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.lifecycle.ViewModel
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.RemoteOrderBy
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchFilterViewModel() : ViewModel() {
    private val _activeScreenViewModel = MutableStateFlow<ScreenViewModel?>(null)
    val activeScreenViewModel = _activeScreenViewModel.asStateFlow()

    private val _isFilterModalVisible = MutableStateFlow(false)
    val isFilterModalVisible = _isFilterModalVisible.asStateFlow()
    private val _isSearchModalVisible = MutableStateFlow(false)
    val isSearchModalVisible = _isSearchModalVisible.asStateFlow()

    private val _newOrderBy = MutableStateFlow<RemoteOrderBy>(RemoteOrderBy.SCORE)
    val newOrderBy = _newOrderBy.asStateFlow()
    private val _newGenreFilter = MutableStateFlow<List<AnimeGenre>?>(null)
    val genreFilter = _newGenreFilter.asStateFlow()
    private val _newSearchQuery = MutableStateFlow<String?>(null)
    val searchQuery = _newSearchQuery.asStateFlow()

    private fun syncQuery() {
        _activeScreenViewModel.value?.let { viewModel ->
            _newOrderBy.value = viewModel.query.value.orderBy
            _newGenreFilter.value = viewModel.query.value.genres
            _newSearchQuery.value = viewModel.query.value.search
        }
    }

    fun setActiveScreenViewModel(viewModel: ScreenViewModel) {
        _activeScreenViewModel.value = viewModel
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
        _isFilterModalVisible.value = false
    }

    fun onOrderByChange(newOrderBy: RemoteOrderBy) {
        _newOrderBy.value = newOrderBy
    }

    fun onGenreFilterChange(newGenreFilter: List<AnimeGenre>?) {
        _newGenreFilter.value = newGenreFilter
    }

    fun onSearchQueryChange(newSearchQuery: String?) {
        _newSearchQuery.value = newSearchQuery
    }

    fun onConfirmButtonClick() {
        _activeScreenViewModel.value?.let { viewModel ->
            viewModel.updateQuery(
                RemoteQueryParameters(
                    orderBy = _newOrderBy.value,
                    genres = _newGenreFilter.value,
                    search = _newSearchQuery.value
                )
            )
            onFilterModalClose()
        }
    }
}