package com.example.taskmanagement.domain.usecase

import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.domain.repository.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskId: String, status: TaskStatus) {
        repository.updateTaskStatus(taskId, status)
    }
}