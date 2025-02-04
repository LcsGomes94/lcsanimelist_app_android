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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.AnimeGenre
import app.vercel.lcsanimelist.domain.model.AnimeSeason
import app.vercel.lcsanimelist.domain.model.Season
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterModalSeasonsField(
    availableSeasons: List<AnimeSeason>,
    newSelectedSeason: AnimeSeason,
    onSelectedSeasonChange: (AnimeSeason) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Seasons",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium
        )
        FlowRow(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            availableSeasons.forEach { season ->
                val isSelected = season == newSelectedSeason
                FilterChip(
                    selected = isSelected,
                    onClick = {
                        if (!isSelected) {
                            onSelectedSeasonChange(season)
                        }
                    },
                    label = {
                        Text(
                            text = season.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    },
                    shape = RoundedCornerShape(50),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Transparent,
                        selectedContainerColor = MaterialTheme.colorScheme.secondary,
                        labelColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.background,
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = MaterialTheme.colorScheme.outline
                    )
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun FilterModalSeasonsPreview() {
    LcsAnimeListTheme {
        FilterModalSeasonsField(
            availableSeasons = listOf(
                AnimeSeason(2025, Season.FALL),
                AnimeSeason(2025, Season.SUMMER),
                AnimeSeason(2025, Season.SPRING),
                AnimeSeason(2025, Season.WINTER),
            ),
            newSelectedSeason = AnimeSeason(2025, Season.SPRING),
            onSelectedSeasonChange = {}
        )
    }
}