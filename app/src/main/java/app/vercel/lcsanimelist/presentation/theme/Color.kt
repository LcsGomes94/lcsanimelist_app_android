package app.vercel.lcsanimelist.presentation.theme

import androidx.compose.ui.graphics.Color
import app.vercel.lcsanimelist.domain.model.PersonalTier


// Dark
val Cyan400 = Color(0xFF22D3EE)
val RqlDark800 = Color(0xFF28282F)
val RqlDark700 = Color(0xFF3C3C46)
val RqlDark850 = Color(0xFF1F1D22)

// Light
val Cyan700 = Color(0xFF0E7490)
val Gray200 = Color(0xFFE5E7EB)
val Gray100 = Color(0xFFF3F4F6)
val White = Color(0xFFFFFFFF)

// General
val Teal500 = Color(0xFF14B8A6)
val RqlDark900 = Color(0xFF1D1B20)
val Slate50 = Color(0xFFF8FAFC)

// Tier
val Teal400 = Color(0xFF2DD4BF)
val Green500 = Color(0xFF22C55E)
val Yellow500 = Color(0xFFEAB308)
val Orange500 = Color(0xFFF97316)
val Red500 = Color(0xFFEF4444)



fun PersonalTier.getColor(): Color {
    return when (this) {
        PersonalTier.SS -> Teal400.copy(alpha = 0.7f)
        PersonalTier.S, PersonalTier.A -> Green500.copy(alpha = 0.7f)
        PersonalTier.B -> Yellow500.copy(alpha = 0.7f)
        PersonalTier.C, PersonalTier.D -> Orange500.copy(alpha = 0.7f)
        PersonalTier.E -> Red500.copy(alpha = 0.7f)
    }
}