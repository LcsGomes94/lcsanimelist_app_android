package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.icon.FavoriteIcon

@Composable
fun AnimeCardFavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onButtonClick: () -> Unit = { }
) {

    IconButton(
        modifier = modifier.size(34.dp),
        onClick = onButtonClick
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