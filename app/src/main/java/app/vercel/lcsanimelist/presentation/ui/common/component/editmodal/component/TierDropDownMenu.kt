package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

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
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalTier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TierDropDownMenu(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = true,
    newTier: PersonalTier? = null,
    onTierChange: (newTier: PersonalTier?) -> Unit = {},
) {

    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it && isFavorite },
    ) {
        TextField(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .height(52.dp),
            value = newTier?.displayName ?: "Select Tier",
            onValueChange = {},
            readOnly = true,
            enabled = isFavorite,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors().copy(
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                disabledContainerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
                focusedIndicatorColor = MaterialTheme.colorScheme.surface,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                focusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
        )
        DropdownMenu(
            modifier = Modifier
                .exposedDropdownSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.background)
                .height(192.dp),
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            PersonalTier.entries.forEachIndexed { index, tier ->
                DropdownMenuItem(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                    text = {
                        Text(
                            text = tier.displayName,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    onClick = {
                        isExpanded = false
                        onTierChange(tier)
                    },
                    enabled = isFavorite,
                    colors = MenuDefaults.itemColors().copy(textColor = MaterialTheme.colorScheme.onSurface),
                )
                if (index < PersonalTier.entries.lastIndex) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp) // Add gap at the beginning and end
                    ) {
                        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.surface.copy(0.8f))
                    }
                }
            }
        }
    }

}