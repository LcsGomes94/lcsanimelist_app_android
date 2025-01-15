package app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.RemoteOrderBy
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListDropdownMenu
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterModal(
    searchFilterViewModel: SearchFilterViewModel,
    modifier: Modifier = Modifier
) {

    val newOrderBy by searchFilterViewModel.newOrderBy.collectAsState()
    val newGenreFilter by searchFilterViewModel.genreFilter.collectAsState()

    val isFilterModalVisible by searchFilterViewModel.isFilterModalVisible.collectAsState()
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (isFilterModalVisible) {
        ModalBottomSheet(
            onDismissRequest = searchFilterViewModel::onFilterModalClose,
            modifier = modifier,
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
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
                Column(
                    modifier = Modifier.fillMaxWidth(),
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
                            newOrderBy?.let { searchFilterViewModel.onOrderByChange(newOrderBy) }
                        },
                        getDisplayName = { it?.displayName ?: "Select Order" },
                        menuItems = RemoteOrderBy.entries,
                        isEnabled = true,
                        primaryColor = MaterialTheme.colorScheme.surfaceContainer,
                        secondaryColor = MaterialTheme.colorScheme.background
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Text(
                        text = "Genres",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    FlowRow(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        AnimeGenre.entries.forEach { genre ->
                            val isSelected: Boolean = newGenreFilter?.contains(genre) == true
                            FilterChip(
                                selected = isSelected,
                                onClick = {
                                    if (isSelected) {
                                        searchFilterViewModel.onGenreFilterChange(
                                            newGenreFilter?.minus(genre)
                                        )
                                    } else {
                                        searchFilterViewModel.onGenreFilterChange(
                                            newGenreFilter?.plus(genre) ?: listOf(genre)
                                        )
                                    }
                                },
                                label = {
                                    Text(
                                        text = genre.displayName,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                shape = RoundedCornerShape(50),
                                colors = FilterChipDefaults.filterChipColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                                    selectedContainerColor = MaterialTheme.colorScheme.secondary,
                                    labelColor = MaterialTheme.colorScheme.primary,
                                    selectedLabelColor = MaterialTheme.colorScheme.background,
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    enabled = true,
                                    selected = true,
                                    borderColor = MaterialTheme.colorScheme.secondary,
                                    selectedBorderColor = MaterialTheme.colorScheme.surfaceContainer
                                )
                            )
                        }
                    }
                }
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
    }

}