package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.icon.FavoriteIcon

@Composable
fun AnimeCardFavoriteButton(
    onButtonClick: () -> Unit,
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    iconStrokeColor: Color = MaterialTheme.colorScheme.onBackground,
    iconFillColor: Color = MaterialTheme.colorScheme.secondary
) {

    IconButton(
        onClick = onButtonClick,
        modifier = modifier
    ) {
        FavoriteIcon(
            isFilled = isFavorite,
            modifier = iconModifier,
            strokeColor = iconStrokeColor,
            fillColor = iconFillColor
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardFavoriteButtonPreview() {
    LcsAnimeListTheme {
        AnimeCardFavoriteButton(
            onButtonClick = {},
            isFavorite = false,
            modifier = Modifier.size(34.dp)
        )
    }
}