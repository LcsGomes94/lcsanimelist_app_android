package app.vercel.lcsanimelist.domain.usecase

data class AnimeUseCases (
    val getAnimeList: GetAnimeListUseCase,

    val getFavoriteAnimeList: GetFavoriteAnimeListUseCase,
    val updateFavorite: UpdateFavoriteAnimeUseCase,
    val addFavorite: AddFavoriteAnimeUseCase,
    val removeFavorite: RemoveFavoriteAnimeUseCase,

    val getSearchHints: GetAnimeSearchHintsUseCase,
    val addToSearchHistory: AddToSearchHistoryUseCase,
    val getFavoriteSearchHints: GetFavoriteSearchHintsUseCase,

    val getAvailableSeasons: GetAvailableAnimeSeasonsUseCase,
    val getSeasonalAnimeList: GetSeasonalAnimeListUseCase
)