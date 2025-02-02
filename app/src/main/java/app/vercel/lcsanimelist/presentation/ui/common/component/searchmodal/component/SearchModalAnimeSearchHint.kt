package app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.domain.model.AnimeSearchHint
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@Composable
fun SearchModalAnimeSearchHint(
    hint: AnimeSearchHint,
    onClick: () -> Unit,
    isNotLastItem: Boolean,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { onClick() },
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (hint.isFromHistory) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.outlined_history
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                )
            } else {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.outlined_search
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = MaterialTheme.colorScheme.onBackground,
                )
            }
            Text(
                text = hint.query,
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .weight(1f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = ImageVector.vectorResource(
                    R.drawable.up_left_arrow
                ),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
            )
        }
        if (isNotLastItem) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 32.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SearchModalAnimeSearchHintPreview() {
    LcsAnimeListTheme {
        SearchModalAnimeSearchHint(
            hint = AnimeSearchHint(
                "Hunter x Hunter",
                isFromHistory = true
            ),
            onClick = {},
            isNotLastItem = false
        )
    }
}