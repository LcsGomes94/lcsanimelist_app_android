package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.domain.model.PersonalStage
import app.vercel.lcsanimelist.domain.model.PersonalTier
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.type.ScreenType

@Composable
fun AnimeCardBottomBar(
    modifier: Modifier = Modifier,
    screenType: ScreenType = ScreenType.HOME,
    personalTier: PersonalTier? = Anime().personalTier,
    score: Double? = Anime().score,
    personalStage: PersonalStage? = Anime().personalStage,
    previewIsFavorite: Boolean = true,
    previewNewTier: PersonalTier? = null,
    onFavoriteToggle: () -> Unit = {},
    openModal: () -> Unit = {},
) {

    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp))
                .background(color = MaterialTheme.colorScheme.surface),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when(screenType) {
                ScreenType.HOME, ScreenType.SEASONAL -> {
                    AnimeCardScore(score = score)
                    AnimeCardFavoriteButton(
                        isFavorite = personalStage != null,
                        onButtonClick = onFavoriteToggle
                    )
                }
                ScreenType.WATCH -> {
                    AnimeCardMoveButton(onButtonClick = openModal)
                    AnimeCardScore(score = score)
                    AnimeCardFavoriteButton(
                        isFavorite = personalStage != null,
                        onButtonClick = onFavoriteToggle
                    )
                }
                ScreenType.FINISHED, ScreenType.DROPPED -> {
                    personalTier?.let { AnimeCardTier(tier = personalTier) }
                    AnimeCardScore(score = score)
                    AnimeCardEditButton(onButtonClick = openModal)
                }
                ScreenType.MODAL -> {
                    if (previewIsFavorite && previewNewTier != null) {
                        AnimeCardTier(tier = previewNewTier)
                    }
                    AnimeCardScore(score = score)
                    AnimeCardFavoriteButton(
                        isFavorite = previewIsFavorite,
                        onButtonClick = onFavoriteToggle
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AnimeCardBottomBarPreview() {
    LcsAnimeListTheme {
        AnimeCardBottomBar()
    }
}
