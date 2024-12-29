package app.vercel.lcsanimelist.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import app.vercel.lcsanimelist.domain.usecase.AnimeUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class HomeViewModel(private val useCases: AnimeUseCases) : ViewModel() {

    private val _query = MutableStateFlow(RemoteQueryParameters())
    val query = _query.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val animePagingData = query
        .flatMapLatest { useCases.getAnimeList(it) }
        .cachedIn(viewModelScope)

    fun updateQuery(newQuery: RemoteQueryParameters) {
        _query.value = newQuery
    }
}