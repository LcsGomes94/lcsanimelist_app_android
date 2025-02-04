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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.LcsAnimeListTopBar
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.LcsAnimeListBottomNavBar
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModal
import app.vercel.lcsanimelist.presentation.ui.common.component.filtermodal.FilterModal
import app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.SearchModal
import app.vercel.lcsanimelist.presentation.ui.home.HomeScreen
import app.vercel.lcsanimelist.presentation.ui.seasonal.SeasonalScreen
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LcsAnimeListTheme {
                KoinAndroidContext {
                    val navController = rememberNavController()
                    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

                    Scaffold { paddingValues ->
                        Scaffold(
                            modifier = Modifier
                                .nestedScroll(scrollBehavior.nestedScrollConnection)
                                .padding(paddingValues),
                            topBar = {
                                LcsAnimeListTopBar(
                                    scrollBehavior = scrollBehavior,
                                    navController = navController,
                                )
                            },
                            bottomBar = {
                                LcsAnimeListBottomNavBar(navController = navController)
                            }
                        ) { innerPadding ->
                            NavGraph(
                                navController = navController,
                                paddingValues = innerPadding
                            )
                            EditModal(
                                paddingValues = paddingValues
                            )
                            FilterModal()
                            SearchModal()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavGraph(
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
            HomeScreen(paddingValues = paddingValues)
        }
        composable("seasonal") {
            SeasonalScreen(paddingValues = paddingValues)
        }
    }
}