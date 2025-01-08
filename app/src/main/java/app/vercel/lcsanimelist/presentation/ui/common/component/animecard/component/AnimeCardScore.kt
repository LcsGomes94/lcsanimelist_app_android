package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun AnimeCardScore(
    modifier: Modifier = Modifier,
    score: Double? = 10.0
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                R.drawable.outlined_score
            ),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = score?.toString() ?: "N/A",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardScorePreview() {
    LcsAnimeListTheme {
        AnimeCardScore()
    }
}