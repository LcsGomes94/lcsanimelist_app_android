package app.vercel.lcsanimelist.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.AnimeCardBottomBar
import app.vercel.lcsanimelist.presentation.ui.common.component.AnimeCardHeader
import app.vercel.lcsanimelist.presentation.ui.common.component.AnimeCardImage
import app.vercel.lcsanimelist.presentation.ui.common.component.AnimeCardTopBar

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    anime: Anime = Anime(),
    onFavoriteToggle: (anime: Anime, isFavorite: Boolean) -> Unit = { _, _ -> }
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimeCardHeader(anime = anime)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimeCardTopBar(anime = anime)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.surface)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(167f / 237f)
                    ) {
                        AnimeCardImage(anime = anime)
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(167f / 237f)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(color = MaterialTheme.colorScheme.surfaceContainer)
                                .verticalScroll(rememberScrollState())
                                .padding(vertical = 6.dp, horizontal = 12.dp)
                        ) {
                            Text(
                                text = anime.synopsis ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        AnimeCardBottomBar(anime = anime, onFavoriteToggle = onFavoriteToggle)
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardPreview() {
    LcsAnimeListTheme {
        AnimeCard()
    }
}