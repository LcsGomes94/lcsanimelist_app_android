package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.Cyan700
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun AnimeCardTopBar(
    modifier: Modifier = Modifier,
    anime: Anime = Anime()
) {

    val genres = anime.genres.take(4)

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
            genres.forEach { genre ->
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.onSurface, shape = RoundedCornerShape(50))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = genre,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardTopBarPreview() {
    LcsAnimeListTheme {
        AnimeCardTopBar()
    }
}