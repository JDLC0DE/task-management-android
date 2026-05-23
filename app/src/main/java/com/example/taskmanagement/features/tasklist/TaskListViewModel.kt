package com.example.taskmanagement.features.tasklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    var state by mutableStateOf(TaskListUiState())
        private set

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            state = try {
                val working = getTasksUseCase(TaskStatus.TODO)
                val inProgress = getTasksUseCase(TaskStatus.IN_PROGRESS)
                val done = getTasksUseCase(TaskStatus.DONE)
                state.copy(
                    tasks = TasksByStatus(working = working, inProgress = inProgress, done = done),
                    isLoading = false
                )
            } catch (e: Exception) {
                state.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}