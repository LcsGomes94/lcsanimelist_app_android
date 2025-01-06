package app.vercel.lcsanimelist.presentation.ui.common.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.ui.common.AnimeCard
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType

@Composable
fun EditModal(
    modifier: Modifier = Modifier,
    anime: Anime,
    viewModel: EditModalViewModel
) {

    val isFavorite by viewModel.isFavorite.collectAsState()
    val newStage by viewModel.newStage.collectAsState()
    val newTier by viewModel.newTier.collectAsState()
    val newPersonalNote by viewModel.newPersonalNote.collectAsState()

    Column(
        modifier = modifier,
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
        )
        Spacer(modifier = Modifier.height(32.dp))
        AnimeCard(
            anime = anime,
            editModalIsFavorite = isFavorite,
            screenType = ScreenType.MODAL,
            onFavoriteToggle = viewModel::onFavoriteToggle
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .align(Alignment.Center),
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
            }
        }
    }

}