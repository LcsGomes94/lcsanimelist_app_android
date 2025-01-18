package app.vercel.lcsanimelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListTopBar
import app.vercel.lcsanimelist.presentation.ui.common.component.ScreenViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.SearchFilterViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.LcsAnimeListBottomNavBar
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.LcsAnimeListBottomNavBarViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModal
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModalViewModel
import app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.FilterModal
import app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.SearchModal
import app.vercel.lcsanimelist.presentation.ui.common.type.ModalActionType
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import app.vercel.lcsanimelist.presentation.ui.home.HomeScreen
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LcsAnimeListTheme {
                KoinAndroidContext {
                    val editModalViewModel: EditModalViewModel = koinViewModel()
                    val searchFilterViewModel: SearchFilterViewModel = koinViewModel()
                    val navBarViewModel: LcsAnimeListBottomNavBarViewModel = koinViewModel()

                    val navController = rememberNavController()
                    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

                    val currentScreen by navBarViewModel.currentScreen.collectAsState()

                    Scaffold { paddingValues ->
                        Scaffold(
                            modifier = Modifier
                                .nestedScroll(scrollBehavior.nestedScrollConnection)
                                .padding(paddingValues),
                            topBar = {
                                LcsAnimeListTopBar(
                                    scrollBehavior = scrollBehavior,
                                    onLogoClick = {
                                        navBarViewModel.onScreenNavigate(
                                            route = "home",
                                            screenType = ScreenType.HOME,
                                            navController = navController
                                        )
                                    },
                                    onFilterClick = searchFilterViewModel::onFilterModalOpen,
                                    onSearchClick = searchFilterViewModel::onSearchModalOpen,
                                )
                            },
                            bottomBar = {
                                LcsAnimeListBottomNavBar(
                                    currentScreen = currentScreen,
                                    navController = navController,
                                    onScreenNavigate = navBarViewModel::onScreenNavigate
                                )
                            }
                        ) { innerPadding ->
                            NavGraph(
                                onEditModalOpen = editModalViewModel::openModal,
                                setActiveScreenViewModel = searchFilterViewModel::setActiveScreenViewModel,
                                navController = navController,
                                paddingValues = innerPadding
                            )
                            EditModal(
                                viewModel = editModalViewModel,
                                paddingValues = paddingValues
                            )
                            FilterModal(searchFilterViewModel = searchFilterViewModel)
                            SearchModal(searchFilterViewModel = searchFilterViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavGraph(
    onEditModalOpen: (Anime, (Anime, ModalActionType) -> Unit) -> Unit,
    setActiveScreenViewModel: (ScreenViewModel) -> Unit,
    navController: NavHostController,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                onEditModalOpen = onEditModalOpen,
                setActiveScreenViewModel = setActiveScreenViewModel,
                paddingValues = paddingValues
            )
        }
    }
}