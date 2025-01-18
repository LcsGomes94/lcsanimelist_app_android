package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component.EditModalContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditModal(
    viewModel: EditModalViewModel,
    modifier: Modifier = Modifier,
) {

    val currentAnimeBeingEdited by viewModel.currentAnimeBeingEdited.collectAsState()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    currentAnimeBeingEdited?.let { anime ->
        ModalBottomSheet(
            onDismissRequest = viewModel::closeModal,
            modifier = modifier,
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            EditModalContent(
                viewModel = viewModel,
                anime = anime,
                sheetState = sheetState
            )
        }
    }

}