package com.example.taskmanagement.core.navigation

sealed class Routes(val route: String) {
    data object TaskListScreen: Routes("task_list")
    data object CreateTaskScreen: Routes("create_task")
    data object EditTaskScreen: Routes("edit_task/{taskId}")
}