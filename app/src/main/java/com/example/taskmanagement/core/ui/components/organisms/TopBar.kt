package com.example.taskmanagement.core.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.components.atoms.Avatar
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .background(TaskTheme.colors.background)
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .background(TaskTheme.colors.neutral40)
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Avatar(url = "https://picsum.photos/200")

            Row {
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
        }
    }
}