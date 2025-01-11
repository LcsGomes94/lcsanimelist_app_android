package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.type.ScreenType
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.AnimeCard
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component.EditModalForm
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component.EditModalTopBar

@Composable
fun EditModal(
    anime: Anime,
    viewModel: EditModalViewModel,
    modifier: Modifier = Modifier,
) {

    val sHeight = LocalConfiguration.current.screenHeightDp
    val isBigPhone = remember(sHeight) { sHeight >= 760 }
    val bottomSheetMaxSize = remember(sHeight) { if (isBigPhone) Dp.Unspecified else 420.dp }
    val formPadding = remember(sHeight) { if (sHeight in 760..860) 16.dp else 24.dp }
    val spacerPadding = remember(sHeight) { if (sHeight in 760..860) 16.dp else 32.dp }
    val cardPadding = remember(sHeight) { if (sHeight in 760..860) 32.dp else 16.dp }

    val isFavorite by viewModel.isFavorite.collectAsState()
    val newStage by viewModel.newStage.collectAsState()
    val newTier by viewModel.newTier.collectAsState()
    val newNote by viewModel.newNote.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        EditModalTopBar(
            title = anime.title,
            onBack = viewModel::closeModal
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.surface.copy(0.8f)
        )
        Spacer(modifier = Modifier.height(spacerPadding))
        if (isBigPhone) {
            AnimeCard(
                anime = anime,
                screenType = ScreenType.MODAL,
                onFavoriteToggle = {
                    viewModel.onFavoriteToggle()
                },
                onModalOpen = {},
                modifier = Modifier.padding(horizontal = cardPadding),
                previewIsFavorite = isFavorite,
                previewNewTier = newTier,
                previewNewNote = newNote
            )
        }
        Spacer(modifier = Modifier.height(spacerPadding))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = bottomSheetMaxSize)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp
                        )
                    )
                    .padding(
                        top = formPadding,
                        start = formPadding,
                        end = formPadding
                    )
            ) {
                EditModalForm(
                    isFavorite = isFavorite,
                    newStage = newStage,
                    newTier = newTier,
                    newNote = newNote,
                    onStageChange = viewModel::onStageChange,
                    onTierChange = viewModel::onTierChange,
                    onNoteChange = viewModel::onNoteChange,
                    onConfirmButtonClick = viewModel::onConfirmButtonClick,
                    onFavoriteToggle = viewModel::onFavoriteToggle,
                    isFavoriteButtonVisible = !isBigPhone,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EditModalPreview() {
    LcsAnimeListTheme {
        EditModal(
            anime = Anime(),
            viewModel = EditModalViewModel()
        )
    }
}