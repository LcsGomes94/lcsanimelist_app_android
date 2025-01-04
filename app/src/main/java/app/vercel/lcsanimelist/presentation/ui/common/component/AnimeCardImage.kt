package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import app.vercel.lcsanimelist.domain.model.Anime
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.util.isPreview

@Composable
fun AnimeCardImage(
    modifier: Modifier = Modifier,
    imageUrl: String = Anime().imageUrl
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
        modifier = modifier.fillMaxWidth(),
        model = model,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

}