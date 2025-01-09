package app.vercel.lcsanimelist.presentation.ui.common.component.animecard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.type.ScreenType
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardBottomBar
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardHeader
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardImage
import app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component.AnimeCardTopBar

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    anime: Anime = Anime(),
    previewIsFavorite: Boolean = true,
    previewNewTier: PersonalTier? = null,
    previewNewNote: String = "",
    screenType: ScreenType = ScreenType.HOME,
    onFavoriteToggle: () -> Unit = { },
    openModal: () -> Unit = { },
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimeCardHeader(
            title = anime.title,
            release = anime.release,
            episodes = anime.episodes,
            isTitleVisible = screenType != ScreenType.MODAL
        )
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimeCardTopBar(genres = anime.genres)
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
                    ) {
                        AnimeCardImage(imageUrl = anime.imageUrl)
                    }
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
                                .verticalScroll(rememberScrollState())
                                .padding(vertical = 6.dp, horizontal = 12.dp)
                        ) {
                            Text(
                                text = if (screenType == ScreenType.MODAL) {
                                    if (previewNewNote.isNotEmpty() && previewIsFavorite) previewNewNote
                                    else anime.synopsis ?: ""
                                } else anime.personalNote ?: anime.synopsis ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        AnimeCardBottomBar(
                            screenType = screenType,
                            personalTier = anime.personalTier,
                            score = anime.score,
                            personalStage = anime.personalStage,
                            previewIsFavorite = previewIsFavorite,
                            previewNewTier = previewNewTier,
                            onFavoriteToggle = onFavoriteToggle,
                            openModal = openModal,
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardPreview() {
    LcsAnimeListTheme {
        AnimeCard()
    }
}