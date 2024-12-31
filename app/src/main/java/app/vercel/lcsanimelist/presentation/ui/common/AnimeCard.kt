package app.vercel.lcsanimelist.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.presentation.util.toAnimeReleaseString
import app.vercel.lcsanimelist.presentation.util.toAnimeEpisodesString
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import app.vercel.lcsanimelist.R
import kotlin.math.round

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    anime: Anime,
    onFavoriteToggle: (anime: Anime, isFavorite: Boolean) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
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
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = anime.release.toAnimeReleaseString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "   |   ",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray.copy(alpha = 0.5f)
            )
            Text(
                text = anime.episodes.toAnimeEpisodesString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                        .background(color = Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        val genres = anime.genres.take(4)
                        items(genres.size) { i ->
                            Box(
                                modifier = Modifier
                                    .background(color = Color.White, shape = RoundedCornerShape(50))
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = genres[i],
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(anime.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(167f / 237f)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(167f / 237f)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(color = Color.White)
                                .padding(8.dp)
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = anime.synopsis ?: "",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                        AnimeCardBottomBar(anime, onFavoriteToggle)
                    }
                }
            }
        }
    }

}

@Composable
fun AnimeCardBottomBar(
    anime: Anime,
    onFavoriteToggle: (anime: Anime, isFavorite: Boolean) -> Unit
) {

    var stage by remember { mutableStateOf(anime.personalStage) }
    val isFavorite = stage != null

    Box(
        modifier = Modifier.background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp))
                .background(color = Color.LightGray)
        ) {
            Row(
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
                    text = anime.score?.toString() ?: "N/A",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            IconButton(
                onClick = {
                    onFavoriteToggle(anime, isFavorite)
                    stage = if (isFavorite) null else PersonalStage.WATCH
                },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        if (isFavorite) R.drawable.filled_favorite_black
                        else R.drawable.outlined_favorite_black
                    ),
                    contentDescription = "add_to_favorite",
                    tint = Color.Unspecified,
                )
            }
        }
    }

}