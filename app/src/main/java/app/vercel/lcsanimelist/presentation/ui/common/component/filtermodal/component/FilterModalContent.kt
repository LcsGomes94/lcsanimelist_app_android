package app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterModalContent(
    searchFilterViewModel: SearchFilterViewModel,
    sheetState: SheetState,
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope()
) {

    val activeScreen by searchFilterViewModel.activeScreen.collectAsState()
    val newOrderBy by searchFilterViewModel.newOrderBy.collectAsState()
    val newGenreFilter by searchFilterViewModel.genreFilter.collectAsState()

    Column(
        modifier = modifier.padding(
            start = 20.dp,
            end = 20.dp,
            bottom = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Search Filters",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyLarge
        )
        FilterModalOrderByField(
            newOrderBy = newOrderBy,
            onOrderByChange = searchFilterViewModel::onOrderByChange,
            screen = activeScreen ?: ScreenType.HOME,
        )
        FilterModalGenresField(
            newGenreFilter = newGenreFilter,
            onGenreFilterChange = searchFilterViewModel::onGenreFilterChange,
            modifier = Modifier.weight(1f, false)
        )
        Button(
            onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        searchFilterViewModel.onConfirmButtonClick()
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        ) {
            Text(
                text = "Confirm",
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun FilterModalContentPreview() {
    LcsAnimeListTheme {
        FilterModalContent(
            searchFilterViewModel = SearchFilterViewModel(),
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        )
    }
}