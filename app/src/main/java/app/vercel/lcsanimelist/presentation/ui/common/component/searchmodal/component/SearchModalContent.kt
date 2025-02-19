package app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchModalContent(
    searchFilterViewModel: SearchFilterViewModel,
    sheetState: SheetState,
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope()
) {

    val newSearchQuery by searchFilterViewModel.newSearchQuery.collectAsState()
    val animeSearchHints by searchFilterViewModel.animeSearchHints.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SearchModalTopBar(
            newSearchQuery = newSearchQuery,
            onSearchQueryChange = searchFilterViewModel::onSearchQueryChange,
            onConfirmButtonClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        searchFilterViewModel.onConfirmButtonClick()
                    }
                }
            },
            onSearchModalClose = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        searchFilterViewModel.onSearchModalClose()
                    }
                }
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(count = animeSearchHints.size) { index ->
                SearchModalAnimeSearchHint(
                    hint = animeSearchHints[index],
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                searchFilterViewModel.onSearchQueryChange(animeSearchHints[index].query)
                                searchFilterViewModel.onConfirmButtonClick()
                            }
                        }
                    },
                    isNotLastItem = index < animeSearchHints.lastIndex
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun SearchModalContentPreview() {
    LcsAnimeListTheme {
        SearchModalContent(
            searchFilterViewModel = SearchFilterViewModel(),
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        )
    }
}