package com.example.taskmanagement.features.createtask

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanagement.core.ui.theme.TaskManagementTheme
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun CreateTaskScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = TaskTheme.colors.background,
        contentColor = TaskTheme.colors.neutral10,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("CreateTask")
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CreateTaskScreenPreview() {
    TaskManagementTheme(darkTheme = true) {
        CreateTaskScreen()
    }
}