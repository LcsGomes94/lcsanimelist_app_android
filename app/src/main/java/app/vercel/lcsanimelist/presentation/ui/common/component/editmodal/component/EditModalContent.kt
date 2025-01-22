package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.AnimeCard
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModalViewModel
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditModalContent(
    viewModel: EditModalViewModel,
    anime: Anime,
    sheetState: SheetState,
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope(),
    paddingValues: PaddingValues = PaddingValues()
) {

    val sHeight = LocalConfiguration.current.screenHeightDp
    val availableHeight = remember(sHeight, paddingValues) {
        sHeight - paddingValues.calculateTopPadding().value - paddingValues.calculateBottomPadding().value
    }

    val isBigPhone = remember(availableHeight) { availableHeight >= 750 }
    val isSmallPhone = remember(availableHeight) { availableHeight < 695 }

    val spacing = if (isBigPhone || isSmallPhone) 20.dp else 16.dp
    val animeCardExtraPadding = if (isBigPhone) 0.dp else 16.dp
    val personalNoteTextFieldModifier = when {
        (isBigPhone || isSmallPhone) -> Modifier.height(160.dp)
        else -> Modifier.height(152.dp)
    }
    val sheetSizeModifier = when {
        isSmallPhone -> modifier
            .fillMaxWidth()
            .height(465.dp)

        else -> modifier.fillMaxSize()
    }

    val isFavorite by viewModel.isFavorite.collectAsState()
    val newStage by viewModel.newStage.collectAsState()
    val newTier by viewModel.newTier.collectAsState()
    val newNote by viewModel.newNote.collectAsState()

    Column(
        modifier = sheetSizeModifier
    ) {
        EditModalTopBar(
            title = anime.title,
            onBack = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        viewModel.closeModal()
                    }
                }
            }
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 16.dp,
                    top = spacing,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            if (!isSmallPhone) {
                AnimeCard(
                    anime = anime,
                    screenType = ScreenType.MODAL,
                    onFavoriteToggle = {
                        viewModel.onFavoriteToggle()
                    },
                    onModalOpen = {},
                    modifier = Modifier.padding(horizontal = animeCardExtraPadding),
                    previewIsFavorite = isFavorite,
                    previewNewTier = newTier,
                    previewNewNote = newNote
                )
            }
            EditModalForm(
                isFavorite = isFavorite,
                newStage = newStage,
                newTier = newTier,
                newNote = newNote,
                onStageChange = viewModel::onStageChange,
                onTierChange = viewModel::onTierChange,
                onNoteChange = viewModel::onNoteChange,
                onConfirmButtonClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            viewModel.onConfirmButtonClick()
                        }
                    }
                },
                onFavoriteToggle = viewModel::onFavoriteToggle,
                isFavoriteButtonVisible = isSmallPhone,
                modifier = Modifier,
                spacing = spacing,
                personalNoteTextFieldModifier = personalNoteTextFieldModifier
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, heightDp = 775)
@Composable
fun EditModalContentPreview() {
    LcsAnimeListTheme {
        EditModalContent(
            viewModel = EditModalViewModel(),
            anime = Anime(),
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        )
    }
}