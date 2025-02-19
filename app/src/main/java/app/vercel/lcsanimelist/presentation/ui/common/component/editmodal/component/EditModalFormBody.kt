package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListDropdownMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditModalFormBody(
    isFavorite: Boolean,
    newStage: PersonalStage?,
    newTier: PersonalTier?,
    newNote: String,
    onStageChange: (newStage: PersonalStage?) -> Unit,
    onTierChange: (newTier: PersonalTier?) -> Unit,
    onNoteChange: (newNote: String) -> Unit,
    modifier: Modifier = Modifier,
    spacing: Dp = 20.dp,
    personalNoteTextFieldModifier: Modifier = Modifier.height(160.dp)
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        LcsAnimeListDropdownMenu<PersonalStage>(
            selectedValue = newStage,
            onMenuItemSelected = onStageChange,
            getDisplayName = { it?.displayName ?: "Select Stage" },
            menuItems = PersonalStage.entries,
            isEnabled = isFavorite
        )
        LcsAnimeListDropdownMenu<PersonalTier>(
            selectedValue = newTier,
            onMenuItemSelected = onTierChange,
            getDisplayName = { it?.displayName ?: "Select Tier" },
            menuItems = PersonalTier.entries,
            isEnabled = isFavorite
        )
        PersonalNoteTextField(
            noteValue = newNote,
            onNoteChange = onNoteChange,
            isEnabled = isFavorite,
            modifier = personalNoteTextFieldModifier
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun EditModalFormBodyPreview() {
    LcsAnimeListTheme {
        EditModalFormBody(
            isFavorite = true,
            newStage = null,
            newTier = null,
            newNote = "",
            onStageChange = {},
            onTierChange = {},
            onNoteChange = {}
        )
    }
}