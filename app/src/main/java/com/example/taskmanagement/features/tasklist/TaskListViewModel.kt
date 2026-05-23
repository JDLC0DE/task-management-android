package com.example.taskmanagement.features.tasklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagement.domain.model.Task
import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.domain.usecase.GetTasksUseCase
import com.example.taskmanagement.domain.usecase.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {

    var state by mutableStateOf(TaskListUiState())
        private set

    init {
        loadTasks()
    }

    fun loadTasks() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                // Obtenemos todas las tareas y las agrupamos localmente para mayor eficiencia
                val working = getTasksUseCase(TaskStatus.TODO)
                val inProgress = getTasksUseCase(TaskStatus.IN_PROGRESS)
                val done = getTasksUseCase(TaskStatus.DONE)
                
                state = state.copy(
                    tasks = TasksByStatus(
                        working = working,
                        inProgress = inProgress,
                        done = done
                    ),
                    isLoading = false
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun onTaskMoved(taskId: String, newStatus: TaskStatus) {
        // Actualización optimista de la UI
        val currentTasks = state.tasks
        val movedTask = findTaskById(taskId, currentTasks) ?: return

        val updatedTasks = removeTaskFromAllColumns(taskId, currentTasks)
        val finalTasks = addTaskToColumn(movedTask.copy(status = newStatus.name), newStatus, updatedTasks)

        state = state.copy(tasks = finalTasks)

        // Actualización remota
        viewModelScope.launch {
            try {
                updateTaskUseCase(taskId, newStatus)
            } catch (e: Exception) {
                // Revertir si hay error
                loadTasks()
                state = state.copy(error = "Error al mover tarea: ${e.message}")
            }
        }
    }

    private fun findTaskById(id: String, tasks: TasksByStatus): Task? {
        return (tasks.working + tasks.inProgress + tasks.done).find { it.id == id }
    }

    private fun removeTaskFromAllColumns(id: String, tasks: TasksByStatus): TasksByStatus {
        return tasks.copy(
            working = tasks.working.filterNot { it.id == id },
            inProgress = tasks.inProgress.filterNot { it.id == id },
            done = tasks.done.filterNot { it.id == id }
        )
    }

    private fun addTaskToColumn(task: Task, status: TaskStatus, tasks: TasksByStatus): TasksByStatus {
        return when (status) {
            TaskStatus.TODO, TaskStatus.BACKLOG -> tasks.copy(working = tasks.working + task)
            TaskStatus.IN_PROGRESS -> tasks.copy(inProgress = tasks.inProgress + task)
            TaskStatus.DONE -> tasks.copy(done = tasks.done + task)
            else -> tasks
        }
    }
}