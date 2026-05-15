package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.taskmanagement.ui.screens.tasklist.TaskListScreen
import com.example.taskmanagement.ui.theme.TaskManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                // Aquí puedes definir el color de fondo si quieres uno específico,
                // pero .dark() por defecto hará que los ICONOS sean BLANCOS.
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            TaskManagementTheme(darkTheme = true) {
                TaskListScreen()
            }
        }
    }
}
