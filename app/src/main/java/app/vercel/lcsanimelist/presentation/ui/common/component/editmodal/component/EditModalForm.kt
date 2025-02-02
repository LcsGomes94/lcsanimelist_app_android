package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardFavoriteButton

@Composable
fun EditModalForm(
    isFavorite: Boolean,
    newStage: PersonalStage?,
    newTier: PersonalTier?,
    newNote: String,
    onStageChange: (newStage: PersonalStage?) -> Unit,
    onTierChange: (newTier: PersonalTier?) -> Unit,
    onNoteChange: (newNote: String) -> Unit,
    onConfirmButtonClick: () -> Unit,
    onFavoriteToggle: () -> Unit,
    isFavoriteButtonVisible: Boolean,
    modifier: Modifier = Modifier,
    spacing: Dp = 20.dp,
    personalNoteTextFieldModifier: Modifier = Modifier.height(160.dp)
) {

    val buttonContainerColor =
        if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        EditModalFormBody(
            isFavorite = isFavorite,
            newStage = newStage,
            newTier = newTier,
            newNote = newNote,
            onStageChange = onStageChange,
            onTierChange = onTierChange,
            onNoteChange = onNoteChange,
            spacing = spacing,
            personalNoteTextFieldModifier = personalNoteTextFieldModifier
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onConfirmButtonClick,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonContainerColor),
            ) {
                Text(
                    text = "Confirm",
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            if (isFavoriteButtonVisible) {
                AnimeCardFavoriteButton(
                    onButtonClick = onFavoriteToggle,
                    isFavorite = isFavorite,
                    modifier = Modifier.size(56.dp),
                    iconModifier = Modifier.size(56.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditModalFormPreview() {
    LcsAnimeListTheme {
        EditModalForm(
            isFavorite = true,
            newStage = null,
            newTier = null,
            newNote = "",
            onStageChange = {},
            onTierChange = {},
            onNoteChange = {},
            onConfirmButtonClick = {},
            onFavoriteToggle = {},
            isFavoriteButtonVisible = true
        )
    }
}