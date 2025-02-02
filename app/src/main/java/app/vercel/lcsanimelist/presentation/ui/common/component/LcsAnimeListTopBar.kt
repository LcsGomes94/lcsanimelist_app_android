package app.vercel.lcsanimelist.presentation.ui.common.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.LcsAnimeListBottomNavBarViewModel
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LcsAnimeListTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    navBarViewModel: LcsAnimeListBottomNavBarViewModel = koinViewModel(),
    searchFilterViewModel: SearchFilterViewModel = koinViewModel()
) {

    TopAppBar(
        title = {},
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(24.dp))
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = MaterialTheme.colorScheme.surfaceDim,
                spotColor = MaterialTheme.colorScheme.surfaceDim
            ),
        navigationIcon = {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(104.dp)
                    .clickable(
                        interactionSource = null,
                        indication = null,
                        onClick = {
                            navBarViewModel.onScreenNavigate(
                                route = "home",
                                screenType = ScreenType.HOME,
                                navController = navController
                            )
                        }
                    )
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.app_logo
                    ),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(104.dp),
                    tint = Color.Unspecified
                )
            }
        },
        actions = {
            IconButton(
                onClick = searchFilterViewModel::onFilterModalOpen
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.outlined_filter
                    ),
                    contentDescription = "filter",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier.width(8.dp))
            IconButton(
                onClick = searchFilterViewModel::onSearchModalOpen,
                modifier = Modifier.padding(end = 4.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.outlined_search
                    ),
                    contentDescription = "search",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        windowInsets = WindowInsets(0.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            scrolledContainerColor = MaterialTheme.colorScheme.background,
        ),
        scrollBehavior = scrollBehavior
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun LcsAnimeListTopBarPreview() {
    LcsAnimeListTheme {
        LcsAnimeListTopBar(
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
            navController = NavHostController(LocalContext.current),
            navBarViewModel = LcsAnimeListBottomNavBarViewModel(),
            searchFilterViewModel = SearchFilterViewModel()
        )
    }
}