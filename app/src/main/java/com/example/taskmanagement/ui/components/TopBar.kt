package com.example.taskmanagement.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.TaskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .background(TaskTheme.colors.background)
            .statusBarsPadding()
    ) {
        TopAppBar(
            title = {},
            windowInsets = WindowInsets(0, 0, 0, 0),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = TaskTheme.colors.onBackground,
            ),
            navigationIcon = { Avatar(url = "https://picsum.photos/200") },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "Buscar",
                        tint = TaskTheme.colors.neutral20
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_notifications),
                        contentDescription = "Notificaciones",
                        tint = TaskTheme.colors.neutral20
                    )
                }
            }
        )
    }
}