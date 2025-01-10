package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.AnimeCard
import app.vercel.lcsanimelist.presentation.type.ScreenType
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.icon.FavoriteIcon
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component.EditModalForm

@Composable
fun EditModal(
    modifier: Modifier = Modifier,
    anime: Anime = Anime(),
    viewModel: EditModalViewModel,
) {

    val sHeight = LocalConfiguration.current.screenHeightDp
    val isBigEnough = remember(sHeight) { sHeight >= 760 }
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .size(56.dp),
                onClick = viewModel::closeModal
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "return",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 24.dp),
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 2.dp),
                    text = anime.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.surface.copy(0.8f))
        Spacer(modifier = Modifier.height(spacerPadding))
        if (isBigEnough) {
            AnimeCard(
                modifier = Modifier.padding(horizontal = cardPadding),
                anime = anime,
                previewIsFavorite = isFavorite,
                previewNewTier = newTier,
                previewNewNote = newNote,
                screenType = ScreenType.MODAL,
                onFavoriteToggle = {
                    if (anime.personalStage != null) viewModel.onFavoriteToggle()
                }
            )
        }
        Spacer(modifier = Modifier.height(spacerPadding))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(top = formPadding, start = formPadding, end = formPadding)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                EditModalForm(
                    isFavorite = isFavorite,
                    newStage = newStage,
                    newTier = newTier,
                    newNote = newNote,
                    onStageChange = viewModel::onStageChange,
                    onTierChange = viewModel::onTierChange,
                    onNoteChange = viewModel::onNoteChange
                )
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor =
                                if (isFavorite) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.error
                            ),
                            onClick = viewModel::onConfirmButtonClick
                        ) {
                            Text(
                                text = "Confirm",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.background
                            )
                        }
                        if (!isBigEnough) {
                            IconButton(
                                modifier = Modifier.size(56.dp),
                                onClick = {
                                    if (anime.personalStage != null) viewModel.onFavoriteToggle()
                                }
                            ) {
                                FavoriteIcon(
                                    modifier = Modifier.size(56.dp),
                                    isFilled = isFavorite
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}