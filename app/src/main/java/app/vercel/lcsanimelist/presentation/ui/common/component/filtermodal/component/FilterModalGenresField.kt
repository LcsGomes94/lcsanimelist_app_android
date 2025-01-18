package app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterModalGenresField(
    newGenreFilter: List<AnimeGenre>?,
    onGenreFilterChange: (List<AnimeGenre>?) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth(),
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
                            onGenreFilterChange(
                                newGenreFilter.minus(genre)
                            )
                        } else {
                            onGenreFilterChange(
                                newGenreFilter?.plus(genre) ?: listOf(genre)
                            )
                        }
                    },
                    label = {
                        Text(
                            text = genre.displayName,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    },
                    shape = RoundedCornerShape(50),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                        selectedContainerColor = MaterialTheme.colorScheme.secondary,
                        labelColor = MaterialTheme.colorScheme.onBackground,
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

}

@Preview(showBackground = true)
@Composable
fun FilterModalGenresPreview() {
    LcsAnimeListTheme {
        FilterModalGenresField(
            newGenreFilter = null,
            onGenreFilterChange = {}
        )
    }
}