package app.vercel.lcsanimelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LcsAnimeListTheme {

                val homeViewModel: HomeViewModel = getViewModel()
                val editModalViewModel: EditModalViewModel = getViewModel()

                val navController = rememberNavController()

                val currentAnimeBeingEdited by editModalViewModel.currentAnimeBeingEdited.collectAsState()

                Scaffold(

                ) { innerPadding ->
                    NavGraph(
                        innerPadding = innerPadding,
                        navController = navController,
                        homeViewModel = homeViewModel,
                        editModalViewModel = editModalViewModel,
                    )
                }

                currentAnimeBeingEdited?.let {
                    Scaffold { innerPadding ->
                        EditModal(
                            modifier = Modifier.padding(innerPadding),
                            anime = currentAnimeBeingEdited ?: Anime(),
                            viewModel = editModalViewModel
                        )
                    }
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
                onEditAnime = editModalViewModel::openModal
            )
        }
    }
}