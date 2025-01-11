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
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.icon.MoveIcon

@Composable
fun AnimeCardMoveButton(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    iconColor: Color = MaterialTheme.colorScheme.onBackground
) {

    IconButton(
        onClick = onButtonClick,
        modifier = modifier,
    ) {
        MoveIcon(
            modifier = iconModifier,
            color = iconColor
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardMoveButtonPreview() {
    LcsAnimeListTheme {
        AnimeCardMoveButton(
            onButtonClick = {},
            modifier = Modifier.size(34.dp)
        )
    }
}