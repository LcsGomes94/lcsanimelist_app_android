package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.icon.MoveIcon

@Composable
fun AnimeCardMoveButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = { }
) {

    IconButton(
        modifier = modifier.size(34.dp),
        onClick = onButtonClick
    ) {
        MoveIcon()
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardMoveButtonPreview() {
    LcsAnimeListTheme {
        AnimeCardMoveButton()
    }
}