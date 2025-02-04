package app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.OrderBy
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListDropdownMenu
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType

@Composable
fun FilterModalOrderByField(
    newOrderBy: OrderBy?,
    onOrderByChange: (OrderBy) -> Unit,
    screen: ScreenType,
    modifier: Modifier = Modifier
) {

    val menuItems = when {
        screen == ScreenType.HOME -> OrderBy.entries.filter { it != OrderBy.TIER }
        else -> OrderBy.entries
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Order by",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium
        )
        LcsAnimeListDropdownMenu<OrderBy>(
            selectedValue = newOrderBy,
            onMenuItemSelected = { newOrderBy ->
                newOrderBy?.let { onOrderByChange(newOrderBy) }
            },
            getDisplayName = { it?.displayName ?: "Select Order" },
            menuItems = menuItems,
            isEnabled = screen != ScreenType.SEASONAL
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun FilterModalOrderByPreview() {
    LcsAnimeListTheme {
        FilterModalOrderByField(
            newOrderBy = null,
            onOrderByChange = {},
            screen = ScreenType.HOME
        )
    }
}