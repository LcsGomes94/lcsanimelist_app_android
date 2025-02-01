package app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.component.SearchModalContent
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchModal(
    modifier: Modifier = Modifier,
    searchFilterViewModel: SearchFilterViewModel = koinViewModel()
) {

    val isSearchModalVisible by searchFilterViewModel.isSearchModalVisible.collectAsState()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (isSearchModalVisible) {
        ModalBottomSheet(
            onDismissRequest = searchFilterViewModel::onSearchModalClose,
            modifier = modifier,
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            SearchModalContent(
                searchFilterViewModel = searchFilterViewModel,
                sheetState
            )
        }
    }

}