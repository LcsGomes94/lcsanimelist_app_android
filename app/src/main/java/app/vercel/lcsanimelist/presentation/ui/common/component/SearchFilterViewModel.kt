package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchFilterViewModel() : ViewModel() {
    private val _activeScreenViewModel = MutableStateFlow<ScreenViewModel?>(null)
    val activeScreenViewModel = _activeScreenViewModel.asStateFlow()

    fun setActiveScreenViewModel(viewModel: ScreenViewModel) {
        _activeScreenViewModel.value = viewModel
    }
}