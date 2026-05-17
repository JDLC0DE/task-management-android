package com.example.taskmanagement.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class TaskColors(
    val neutral10: Color,
    val neutral20: Color,
    val neutral30: Color,
    val neutral40: Color,
    val neutral50: Color,

    val primary10: Color,
    val primary20: Color,
    val primary30: Color,
    val primary40: Color,

    val secondary10: Color,
    val secondary20: Color,
    val secondary30: Color,
    val secondary40: Color,

    val tertiary10: Color,
    val tertiary20: Color,
    val tertiary30: Color,
    val tertiary40: Color,

    val background: Color,
    val onBackground: Color,

    val isDark: Boolean,
)