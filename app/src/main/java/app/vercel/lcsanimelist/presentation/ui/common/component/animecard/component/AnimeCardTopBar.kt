package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun AnimeCardTopBar(
    genres: List<String>,
    modifier: Modifier = Modifier
) {

    val cappedGenres = genres.take(4)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(color = MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            cappedGenres.forEach { genre ->
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.surfaceContainer,
                            shape = RoundedCornerShape(50)
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 2.dp
                        )
                ) {
                    Text(
                        text = genre,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AnimeCardTopBarPreview() {
    LcsAnimeListTheme {
        AnimeCardTopBar(genres = Anime().genres)
    }
}