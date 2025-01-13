package app.vercel.lcsanimelist.presentation.ui.common.component.topbar

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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LcsAnimeListTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onLogoClick: () -> Unit,
    onFilterClick: () -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    TopAppBar(
        title = {},
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = MaterialTheme.colorScheme.onBackground,
                spotColor = MaterialTheme.colorScheme.onBackground
            ),
        navigationIcon = {
            IconButton(
                onClick = onLogoClick,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(104.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.app_logo
                    ),
                    contentDescription = "logo",
                    modifier = Modifier.size(104.dp),
                    tint = Color.Unspecified
                )
            }
        },
        actions = {
            IconButton(
                onClick = onFilterClick
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
                onClick = onSearchClick
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
fun LcsAnimeListTopBarPreview() {
    LcsAnimeListTheme {
        LcsAnimeListTopBar(
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
            onLogoClick = {},
            onFilterClick = {},
            onSearchClick = {},
        )
    }
}