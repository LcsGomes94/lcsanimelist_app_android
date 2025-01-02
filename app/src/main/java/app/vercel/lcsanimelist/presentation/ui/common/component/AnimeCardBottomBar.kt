package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun AnimeCardBottomBar(
    modifier: Modifier = Modifier,
    anime: Anime = Anime(),
    onFavoriteToggle: (anime: Anime, isFavorite: Boolean) -> Unit = { _, _ -> }
) {

    var stage by rememberSaveable() { mutableStateOf(anime.personalStage) }
    val isFavorite = stage != null

    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.onSurface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp))
                .background(color = MaterialTheme.colorScheme.surface),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
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
                modifier = Modifier.size(34.dp),
                onClick = {
                    onFavoriteToggle(anime, isFavorite)
                    stage = if (isFavorite) null else PersonalStage.WATCH
                }
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

@Preview(showBackground = true)
@Composable
fun AnimeCardBottomBarPreview() {
    LcsAnimeListTheme {
        AnimeCardBottomBar()
    }
}
