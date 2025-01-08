package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.util.extension.toAnimeEpisodesString
import app.vercel.lcsanimelist.util.extension.toAnimeReleaseString
import java.time.LocalDate

@Composable
fun AnimeCardHeader(
    modifier: Modifier = Modifier,
    title: String = Anime().title,
    release: LocalDate? = Anime().release,
    episodes: Int? = Anime().episodes,
    isTitleVisible: Boolean = true,
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (isTitleVisible) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = release.toAnimeReleaseString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                modifier = Modifier.alpha(0.1f),
                text = "   |   ",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = episodes.toAnimeEpisodesString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardHeaderPreview() {
    LcsAnimeListTheme {
        AnimeCardHeader()
    }
}