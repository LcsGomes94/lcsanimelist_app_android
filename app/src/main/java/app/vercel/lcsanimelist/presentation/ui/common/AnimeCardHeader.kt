package app.vercel.lcsanimelist.presentation.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.util.toAnimeEpisodesString
import app.vercel.lcsanimelist.presentation.util.toAnimeReleaseString

@Composable
fun AnimeCardHeader(
    modifier: Modifier = Modifier,
    anime: Anime = Anime()
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = anime.title,
            style = MaterialTheme.typography.titleLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = anime.release.toAnimeReleaseString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier.alpha(0.1f),
                text = "   |   ",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = anime.episodes.toAnimeEpisodesString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}