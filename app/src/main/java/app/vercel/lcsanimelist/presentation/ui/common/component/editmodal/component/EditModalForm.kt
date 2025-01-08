package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditModalForm(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = true,
    newStage: PersonalStage? = null,
    newTier: PersonalTier? = null,
    newNote: String = "",
    onStageChange: (newStage: PersonalStage?) -> Unit = {},
    onTierChange: (newTier: PersonalTier?) -> Unit = {},
    onNoteChange: (newNote: String) -> Unit = {}
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        StageDropDownMenu(
            isFavorite = isFavorite,
            newStage = newStage,
            onStageChange = onStageChange
        )
        TierDropDownMenu(
            isFavorite = isFavorite,
            newTier = newTier,
            onTierChange = onTierChange
        )
        PersonalNoteTextField(
            isFavorite = isFavorite,
            newNote = newNote,
            onNoteChange = onNoteChange
        )
    }

}

@Preview(showBackground = true)
@Composable
fun EditModalFormPreview() {
    LcsAnimeListTheme {
        EditModalForm()
    }
}