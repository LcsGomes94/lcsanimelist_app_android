package app.vercel.lcsanimelist.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Cyan400,
    secondary = Teal500,
    surface = Gray800,
    surfaceContainer = Gray700,
    onSurface = Gray50,
    background = Gray900,
    onBackground = White,

)

private val LightColorScheme = lightColorScheme(
    primary = Cyan700,
    secondary = Teal500,
    surface = Gray200,
    surfaceContainer = Gray100,
    onSurface = Gray900,
    background = White,
    onBackground = Gray900
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