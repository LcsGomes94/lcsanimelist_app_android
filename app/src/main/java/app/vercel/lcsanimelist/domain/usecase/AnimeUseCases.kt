package app.vercel.lcsanimelist.domain.usecase

data class AnimeUseCases (
    val getAnimeList: GetAnimeListUseCase,
    val updateFavorite: UpdateFavoriteAnimeUseCase,
    val addFavorite: AddFavoriteAnimeUseCase,
    val removeFavorite: RemoveFavoriteAnimeUseCase,

    val getSearchHints: GetAnimeSearchHintsUseCase,
    val addToSearchHistory: AddToSearchHistoryUseCase,
)