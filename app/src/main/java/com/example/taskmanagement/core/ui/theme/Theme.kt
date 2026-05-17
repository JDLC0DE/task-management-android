package com.example.taskmanagement.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LightTaskColors = TaskColors(
    Neutral1,
    Neutral2,
    Neutral3,
    Neutral4,
    Neutral5,
    Primary1,
    Primary2,
    Primary3,
    Primary4,
    Secondary1,
    Secondary2,
    Secondary3,
    Secondary4,
    Tertiary1,
    Tertiary2,
    Tertiary3,
    Tertiary4,
    background = Neutral5,
    onBackground = Neutral4,
    isDark = false,
)

val DarkTaskColors = TaskColors(
    Neutral1,
    Neutral2,
    Neutral3,
    Neutral4,
    Neutral5,
    Primary1,
    Primary2,
    Primary3,
    Primary4,
    Secondary1,
    Secondary2,
    Secondary3,
    Secondary4,
    Tertiary1,
    Tertiary2,
    Tertiary3,
    Tertiary4,
    background = Neutral5,
    onBackground = Neutral4,
    isDark = true,
)

val LocalTaskColors = staticCompositionLocalOf { LightTaskColors }

object TaskTheme {
    val colors: TaskColors
        @Composable
        get() = LocalTaskColors.current
}

@Composable
fun TaskManagementTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkTaskColors else LightTaskColors

    CompositionLocalProvider(LocalTaskColors provides colors) {
        MaterialTheme(content = content)
    }
}