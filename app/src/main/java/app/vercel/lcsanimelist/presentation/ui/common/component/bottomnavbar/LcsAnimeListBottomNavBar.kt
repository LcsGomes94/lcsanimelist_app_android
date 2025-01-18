package app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme
import app.vercel.lcsanimelist.presentation.ui.common.component.bottomnavbar.type.LcsAnimeListBottomNavItem
import app.vercel.lcsanimelist.presentation.ui.common.type.ScreenType

@Composable
fun LcsAnimeListBottomNavBar(
    currentScreen: ScreenType,
    navController: NavHostController,
    onScreenNavigate: (String, ScreenType, NavHostController) -> Unit,
    modifier: Modifier = Modifier
) {

    val sWidth = LocalConfiguration.current.screenWidthDp
    val isPhoneLargeEnough = remember(sWidth) { sWidth >= 375 }

    NavigationBar(
        modifier = modifier
            .height(92.dp)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = MaterialTheme.colorScheme.onBackground,
                spotColor = MaterialTheme.colorScheme.onBackground
            ),
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        windowInsets = WindowInsets(0.dp),
    ) {
        LcsAnimeListBottomNavItem.entries.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentScreen == item.screenType,
                onClick = {
                    onScreenNavigate(item.route, item.screenType, navController)
                },
                icon = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(item.iconRes),
                            contentDescription = item.title,
                        )
                        Text(
                            item.title,
                            color = MaterialTheme.colorScheme.onBackground,
                            maxLines = 1,
                            style = when {
                                isPhoneLargeEnough -> MaterialTheme.typography.labelMedium
                                else -> MaterialTheme.typography.labelSmall
                            },
                        )
                    }
                },
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 20.dp else 0.dp,
                        end = if (index == 4) 20.dp else 0.dp
                    ),

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary,
                    indicatorColor = MaterialTheme.colorScheme.surfaceContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LcsAnimeListBottomNavBarPreview() {
    LcsAnimeListTheme {
        LcsAnimeListBottomNavBar(
            currentScreen = ScreenType.HOME,
            navController = NavHostController(LocalContext.current),
            onScreenNavigate = { _, _, _ -> }
        )
    }
}