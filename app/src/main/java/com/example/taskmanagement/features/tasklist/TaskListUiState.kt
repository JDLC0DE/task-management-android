package com.example.taskmanagement.features.tasklist

import com.example.taskmanagement.domain.model.Task

data class TasksByStatus(
    val working: List<Task> = emptyList(),
    val inProgress: List<Task> = emptyList(),
    val done: List<Task> = emptyList()
)

data class TaskListUiState(
    val tasks: TasksByStatus = TasksByStatus(),
    val isLoading: Boolean = false,
    val error: String? = null
)