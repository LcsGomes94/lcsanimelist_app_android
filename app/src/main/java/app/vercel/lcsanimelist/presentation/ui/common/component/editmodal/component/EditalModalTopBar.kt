package app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun EditModalTopBar(
    title: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.size(56.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = "return",
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
        Box(
            modifier = Modifier.padding(end = 24.dp),
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(bottom = 2.dp),
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall
            )
        }
        BackHandler(onBack = onBack)
    }

}

@Preview(showBackground = true)
@Composable
fun EditModalTopBarPreview() {
    LcsAnimeListTheme {
        EditModalTopBar(
            title = Anime().title,
            onBack = {}
        )
    }
}