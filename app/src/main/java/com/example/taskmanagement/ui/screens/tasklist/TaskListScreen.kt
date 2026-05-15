package com.example.taskmanagement.ui.screens.tasklist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.components.CardItem
import com.example.taskmanagement.ui.components.TopBar
import com.example.taskmanagement.ui.theme.TaskTheme
import com.example.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun TaskListScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = TaskTheme.colors.background,
        contentColor = TaskTheme.colors.neutral10,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { print("Hello") },
                containerColor = TaskTheme.colors.primary40,
                contentColor = TaskTheme.colors.neutral10,
                shape = CircleShape
            ) {
                Icon(painterResource(R.drawable.ic_add), "Añadir")
            }
        },
        topBar = { TopBar() }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            CardItem()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TaskListPreview() {
    TaskManagementTheme(darkTheme = true) {
        TaskListScreen()
    }
}