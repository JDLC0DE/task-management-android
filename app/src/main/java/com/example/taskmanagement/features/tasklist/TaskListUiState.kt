package com.example.taskmanagement.features.tasklist

import com.example.taskmanagement.domain.model.Task

data class TaskListUiState(
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)