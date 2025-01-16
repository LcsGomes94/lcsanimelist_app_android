package app.vercel.lcsanimelist.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Cyan400,
    secondary = Teal500,
    surface = RqlDark800,
    surfaceContainer = RqlDark700,
    background = RqlDark900,
    onBackground = Slate50,
    error = Red500,
    primaryContainer = RqlDark850
)

private val LightColorScheme = lightColorScheme(
    primary = Cyan700,
    secondary = Teal500,
    surface = Gray200,
    surfaceContainer = Gray100,
    background = White,
    onBackground = RqlDark900,
    error = Red500,
    primaryContainer = Slate50
)

@Composable
fun LcsAnimeListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}