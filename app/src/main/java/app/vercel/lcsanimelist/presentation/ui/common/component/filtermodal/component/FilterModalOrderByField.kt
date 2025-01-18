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
import app.vercel.lcsanimelist.domain.model.RemoteOrderBy
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListDropdownMenu

@Composable
fun FilterModalOrderByField(
    newOrderBy: RemoteOrderBy?,
    onOrderByChange: (RemoteOrderBy) -> Unit,
    modifier: Modifier = Modifier
) {

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
        LcsAnimeListDropdownMenu<RemoteOrderBy>(
            selectedValue = newOrderBy,
            onMenuItemSelected = { newOrderBy ->
                newOrderBy?.let { onOrderByChange(newOrderBy) }
            },
            getDisplayName = { it?.displayName ?: "Select Order" },
            menuItems = RemoteOrderBy.entries,
            isEnabled = true
        )
    }

}

@Preview(showBackground = true)
@Composable
fun FilterModalOrderByPreview() {
    LcsAnimeListTheme {
        FilterModalOrderByField(
            newOrderBy = null,
            onOrderByChange = {}
        )
    }
}