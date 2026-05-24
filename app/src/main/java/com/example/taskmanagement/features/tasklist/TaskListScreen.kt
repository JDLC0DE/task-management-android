package com.example.taskmanagement.features.tasklist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.components.organisms.DragAndDropContainer
import com.example.taskmanagement.core.ui.components.organisms.TopBar
import com.example.taskmanagement.core.ui.theme.TaskTheme
import com.example.taskmanagement.core.ui.theme.TaskManagementTheme
import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.features.tasklist.components.TaskColumn

@Composable
fun TaskListScreen(
    onNavigateToCreateTask: () -> Unit,
    viewModel: TaskListViewModel = hiltViewModel()
) {
    DragAndDropContainer {
        TaskListContent(
            state = viewModel.state,
            onNavigateToCreateTask = onNavigateToCreateTask,
            onTaskMoved = { taskId, targetColumn ->
                val newStatus = when (targetColumn) {
                    "WORKING" -> TaskStatus.TODO
                    "IN_PROGRESS" -> TaskStatus.IN_PROGRESS
                    "DONE" -> TaskStatus.DONE
                    else -> TaskStatus.TODO
                }
                viewModel.onTaskMoved(taskId, newStatus)
            }
        )
    }
}

@Composable
fun TaskListContent(
    state: TaskListUiState,
    onNavigateToCreateTask: () -> Unit,
    onTaskMoved: (String, String) -> Unit = { _, _ -> }
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = TaskTheme.colors.background,
        contentColor = TaskTheme.colors.neutral10,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToCreateTask,
                containerColor = TaskTheme.colors.primary40,
                contentColor = TaskTheme.colors.neutral10,
                shape = CircleShape
            ) {
                Icon(painterResource(R.drawable.ic_add), "add")
            }
        },
        topBar = { TopBar() }
    ) { innerPadding ->
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(21.dp),
            contentPadding = PaddingValues(horizontal = 21.dp)
        ) {

            item {
                TaskColumn(
                    title = "Working",
                    tasks = state.tasks.working,
                    targetId = "WORKING",
                    onTaskMoved = onTaskMoved
                )
            }

            item {
                TaskColumn(
                    title = "In Progress",
                    tasks = state.tasks.inProgress,
                    targetId = "IN_PROGRESS",
                    onTaskMoved = onTaskMoved
                )
            }

            item {
                TaskColumn(
                    title = "Done",
                    tasks = state.tasks.done,
                    targetId = "DONE",
                    onTaskMoved = onTaskMoved
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun TaskListScreenPreview() {
    TaskManagementTheme(darkTheme = true) {
        TaskListContent(
            state = TaskListUiState(),
            onNavigateToCreateTask = {}
        )
    }
}