package app.vercel.lcsanimelist.presentation.ui.common.component.animecard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardSkeletonBottomBar
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardSkeletonHeader
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardSkeletonSynopsisLine
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardSkeletonTopBar

@Composable
fun AnimeCardSkeleton(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimeCardSkeletonHeader()
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimeCardSkeletonTopBar()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.surface)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(167f / 237f)
                            .background(color = MaterialTheme.colorScheme.surfaceVariant)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(167f / 237f)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(color = MaterialTheme.colorScheme.surfaceContainer)
                                .padding(
                                    vertical = 6.dp,
                                    horizontal = 12.dp
                                ),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            repeat(3) {
                                AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth())
                            }
                            AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth(0.5f))
                            AnimeCardSkeletonSynopsisLine()
                            repeat(3) {
                                AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth())
                            }
                            AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth(0.8f))
                            AnimeCardSkeletonSynopsisLine()
                            AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth(0.95f))
                            AnimeCardSkeletonSynopsisLine(modifier = Modifier.fillMaxWidth(0.3f))
                        }
                        AnimeCardSkeletonBottomBar()
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AnimeCardSkeletonPreview() {
    LcsAnimeListTheme {
        AnimeCardSkeleton()
    }
}