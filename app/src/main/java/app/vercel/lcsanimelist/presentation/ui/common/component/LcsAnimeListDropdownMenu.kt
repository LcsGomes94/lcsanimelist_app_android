package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.clip
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
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colorScheme.background,
    secondaryColor: Color = MaterialTheme.colorScheme.surface
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
                .height(52.dp),
            enabled = isEnabled,
            readOnly = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            shape = RoundedCornerShape(8.dp),
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                unfocusedContainerColor = primaryColor,
                focusedContainerColor = primaryColor,
                disabledContainerColor = primaryColor.copy(alpha = 0.7f),
                focusedIndicatorColor = secondaryColor,
                unfocusedIndicatorColor = secondaryColor,
                disabledIndicatorColor = secondaryColor,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedTrailingIconColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onBackground
            )
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier
                .exposedDropdownSize()
                .background(color = secondaryColor)
                .clip(RoundedCornerShape(8.dp))
                .background(color = primaryColor)
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
                    modifier = Modifier.background(color = primaryColor),
                    enabled = isEnabled,
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.onBackground
                    ),
                )
                if (index < menuItems.lastIndex) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = secondaryColor.copy(0.8f)
                        )
                    }
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