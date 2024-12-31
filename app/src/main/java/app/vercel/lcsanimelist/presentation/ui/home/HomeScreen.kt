package app.vercel.lcsanimelist.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import app.vercel.lcsanimelist.presentation.ui.common.AnimeCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier
) {

    val animePagingItems = viewModel.animePagingData.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        if (animePagingItems.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "LOADING ANIMES!",
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        items(count = animePagingItems.itemCount) { i ->
            val anime = animePagingItems[i]!!
            AnimeCard(anime = anime, onFavoriteToggle = viewModel::onFavoriteToggle)
        }

        if (animePagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        if (animePagingItems.loadState.append is LoadState.Error) {
            item {
                ErrorItem(
                    message = (animePagingItems.loadState.append as LoadState.Error).error.message ?: "An error occurred",
                    onRetry = { animePagingItems.retry() }
                )
            }
        }
    }
}

@Composable
fun ErrorItem(message: String, onRetry: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error
        )
        Button(onClick = onRetry) {
            Text(text = "Retry")
        }
    }
}