package app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.type

import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType

enum class LcsAnimeListBottomNavItem(
    val iconRes: Int,
    val title: String,
    val route: String,
    val screenType: ScreenType
) {
    HOME(R.drawable.home_icon, "Home", "home", ScreenType.HOME),
    SEASONAL(R.drawable.seasonal_icon, "Seasonal", "seasonal", ScreenType.SEASONAL),
    WATCH(R.drawable.watch_icon, "Watch List", "watch", ScreenType.WATCH),
    FINISHED(R.drawable.finished_icon, "Finished", "finished", ScreenType.FINISHED),
    DROPPED(R.drawable.dropped_icon, "Dropped", "dropped", ScreenType.DROPPED);
}