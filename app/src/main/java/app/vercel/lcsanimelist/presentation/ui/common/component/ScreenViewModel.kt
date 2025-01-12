package app.vercel.lcsanimelist.presentation.ui.common.component

import app.vercel.lcsanimelist.domain.model.RemoteQueryParameters
import kotlinx.coroutines.flow.StateFlow

interface ScreenViewModel {
    val query: StateFlow<RemoteQueryParameters>
    fun updateQuery(newQuery: RemoteQueryParameters)
}