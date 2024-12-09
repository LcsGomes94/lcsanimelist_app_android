package app.vercel.lcsanimelist.domain.usecase

data class AnimeUseCases (
    val getAnimeList: GetAnimeListUseCase,
    val updateFavorite: UpdateFavoriteAnimeUseCase
)