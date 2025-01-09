package app.vercel.lcsanimelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.vercel.lcsanimelist.domain.model.Anime
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModal
import app.vercel.lcsanimelist.presentation.ui.common.component.editmodal.EditModalViewModel
import app.vercel.lcsanimelist.presentation.ui.home.HomeScreen
import app.vercel.lcsanimelist.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LcsAnimeListTheme {

                val homeViewModel: HomeViewModel = getViewModel()
                val editModalViewModel: EditModalViewModel = getViewModel()

                val currentAnimeBeingEdited by editModalViewModel.currentAnimeBeingEdited.collectAsState()

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(
                        innerPadding = innerPadding,
                        navController = navController,
                        homeViewModel = homeViewModel,
                        editModalViewModel = editModalViewModel,
                        currentAnimeBeingEdited = currentAnimeBeingEdited
                    )
                }
            }
        }
    }
}

@Composable
fun NavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    editModalViewModel: EditModalViewModel,
    currentAnimeBeingEdited: Anime?
) {
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = homeViewModel,
                onEditAnime = { anime, callback ->
                    editModalViewModel.openModal(anime, callback)
                    navController.navigate("editModal")
                }
            )
        }

        composable("editModal") { backStackEntry ->
            currentAnimeBeingEdited?.let { anime ->
                EditModal(
                    modifier = Modifier.fillMaxSize(),
                    anime = anime,
                    viewModel = editModalViewModel,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}