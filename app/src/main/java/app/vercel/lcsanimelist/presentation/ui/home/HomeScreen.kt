package app.vercel.lcsanimelist.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.type.ModalActionType
import app.vercel.lcsanimelist.presentation.type.ScreenType
import app.vercel.lcsanimelist.presentation.ui.common.component.ScreenViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.AnimeCard
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.OnConfirmCallback
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onEditModalOpen: (Anime, OnConfirmCallback) -> Unit,
    setActiveScreenViewModel: (ScreenViewModel) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    paddingValues: PaddingValues = PaddingValues()
) {

    LaunchedEffect(Unit) {
        setActiveScreenViewModel(viewModel)
    }

    val animePagingItems = viewModel.updatedAnimePagingData.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding() + 32.dp,
            bottom = paddingValues.calculateBottomPadding() + 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(48.dp),
    ) {
        if (animePagingItems.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "LOADING ANIMES!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        items(count = animePagingItems.itemCount) { i ->
            val anime = animePagingItems[i]!!
            AnimeCard(
                anime = anime,
                screenType = ScreenType.WATCH,
                onFavoriteToggle = {
                    viewModel.onFavoriteToggle(anime)
                },
                onModalOpen = {
                    onEditModalOpen(anime) { anime, action ->
                        when (action) {
                            ModalActionType.UPDATE -> viewModel.updateFavorite(anime)
                            ModalActionType.DELETE -> viewModel.removeFavorite(anime)
                        }
                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        if (animePagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        if (animePagingItems.loadState.append is LoadState.Error) {
            item {
                ErrorItem(
                    message = (animePagingItems.loadState.append as LoadState.Error).error.message
                        ?: "An error occurred",
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