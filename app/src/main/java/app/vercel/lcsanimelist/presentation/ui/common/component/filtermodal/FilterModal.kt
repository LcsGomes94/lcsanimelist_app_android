package app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.component.FilterModalContent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterModal(
    searchFilterViewModel: SearchFilterViewModel,
    modifier: Modifier = Modifier
) {

    val isFilterModalVisible by searchFilterViewModel.isFilterModalVisible.collectAsState()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (isFilterModalVisible) {
        ModalBottomSheet(
            onDismissRequest = searchFilterViewModel::onFilterModalClose,
            modifier = modifier,
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            FilterModalContent(
                searchFilterViewModel = searchFilterViewModel,
                sheetState
            )
        }
    }

}