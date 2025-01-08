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
    modifier: Modifier = Modifier,
    tier: PersonalTier = PersonalTier.SS
) {

    Box(
        modifier.size(34.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(height = 16.dp, width = 24.dp)
                .background(color = tier.getColor(), shape = RoundedCornerShape(25)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = tier.name,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
            )
        }
    }


}

@Preview(showBackground = false)
@Composable
fun AnimeCardTierPreview() {
    LcsAnimeListTheme {
        AnimeCardTier()
    }
}