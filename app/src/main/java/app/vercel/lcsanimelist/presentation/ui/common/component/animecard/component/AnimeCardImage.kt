package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.util.isPreview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun AnimeCardImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {

    val model = if (isPreview()) {
        R.drawable.anime_image_preview
    } else {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build()
    }

    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )

}