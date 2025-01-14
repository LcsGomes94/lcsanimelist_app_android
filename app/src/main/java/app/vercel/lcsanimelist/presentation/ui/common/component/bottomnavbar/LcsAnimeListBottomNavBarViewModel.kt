package app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LcsAnimeListBottomNavBarViewModel : ViewModel() {
    private val _currentScreen = MutableStateFlow(ScreenType.HOME)
    val currentScreen = _currentScreen.asStateFlow()

    fun onScreenNavigate(route: String, screenType: ScreenType, navController: NavHostController) {
        _currentScreen.value = screenType
        navController.navigate(route)
    }
}