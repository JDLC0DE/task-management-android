package com.example.taskmanagement.domain.repository

import com.example.taskmanagement.domain.model.Task
import com.example.taskmanagement.domain.model.TaskStatus

interface TaskRepository {
    suspend fun getTasks(status: TaskStatus? = null): List<Task>
}