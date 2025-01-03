package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.icon.FavoriteIcon

@Composable
fun AnimeCardFavoriteButton(
    modifier: Modifier = Modifier,
    anime: Anime = Anime(),
    onButtonClick: (anime: Anime, isFavorite: Boolean) -> Unit = { _, _ -> }
) {

    var stage by rememberSaveable() { mutableStateOf(anime.personalStage) }
    val isFavorite = stage != null

    IconButton(
        modifier = modifier.size(34.dp),
        onClick = {
            onButtonClick(anime, isFavorite)
            stage = if (isFavorite) null else PersonalStage.WATCH
        }
    ) {
        FavoriteIcon(isFavorite)
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardFavoriteButtonPreview() {
    LcsAnimeListTheme {
        AnimeCardFavoriteButton()
    }
}