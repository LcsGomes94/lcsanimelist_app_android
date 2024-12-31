package app.vercel.lcsanimelist.presentation.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import app.vercel.lcsanimelist.domain.model.Anime
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun AnimeCardImage(
    modifier: Modifier = Modifier,
    anime: Anime = Anime()
) {

    AsyncImage(
        modifier = modifier.fillMaxWidth(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(anime.imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )

}