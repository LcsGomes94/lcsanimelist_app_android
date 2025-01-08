package app.vercel.lcsanimelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

                Box(modifier = Modifier.fillMaxSize()) {

                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        HomeScreen(
                            Modifier.padding(innerPadding),
                            homeViewModel,
                            editModalViewModel
                        )
                    }

                    currentAnimeBeingEdited?.let { anime ->
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            EditModal(
                                modifier = Modifier.padding(innerPadding),
                                anime = anime,
                                viewModel = editModalViewModel,
                            )
                        }
                    }
                }

            }
        }
    }
}