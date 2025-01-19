package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import kotlin.enums.EnumEntries

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Enum<T>> LcsAnimeListDropdownMenu(
    selectedValue: T?,
    onMenuItemSelected: (newValue: T?) -> Unit,
    getDisplayName: (value: T?) -> String,
    menuItems: EnumEntries<T>,
    isEnabled: Boolean,
    modifier: Modifier = Modifier
) {

    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it && isEnabled },
        modifier = modifier
    ) {
        TextField(
            value = getDisplayName(selectedValue),
            onValueChange = {},
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .height(52.dp)
                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp)),
            enabled = isEnabled,
            readOnly = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedTrailingIconColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onBackground
            )
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.exposedDropdownSize(),
            shape = RoundedCornerShape(8.dp),
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ) {
            menuItems.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = getDisplayName(item),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    onClick = {
                        isExpanded = false
                        onMenuItemSelected(item)
                    },
                    enabled = isEnabled,
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.onBackground
                    ),
                )
                if (index < menuItems.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LcsAnimeListDropdownMenuPreview() {
    LcsAnimeListTheme {
        LcsAnimeListDropdownMenu(
            selectedValue = null,
            onMenuItemSelected = {},
            getDisplayName = { it?.displayName ?: "Select Stage" },
            menuItems = PersonalStage.entries,
            isEnabled = true
        )
    }
}