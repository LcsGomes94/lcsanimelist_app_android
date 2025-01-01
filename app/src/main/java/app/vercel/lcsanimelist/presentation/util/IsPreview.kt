package app.vercel.lcsanimelist.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode

@Composable
fun isPreview(): Boolean {
    return LocalInspectionMode.current
}