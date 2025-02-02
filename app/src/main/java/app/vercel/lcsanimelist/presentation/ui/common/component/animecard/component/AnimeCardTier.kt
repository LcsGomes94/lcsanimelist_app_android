package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.theme.getColor

@Composable
fun AnimeCardTier(
    tier: PersonalTier,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(
                    height = 16.dp,
                    width = 24.dp
                )
                .background(
                    color = tier.getColor(),
                    shape = RoundedCornerShape(25)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = tier.name,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

}

@Preview(showBackground = false)
@Composable
private fun AnimeCardTierPreview() {
    LcsAnimeListTheme {
        AnimeCardTier(
            tier = PersonalTier.SS,
            modifier = Modifier.size(34.dp)
        )
    }
}