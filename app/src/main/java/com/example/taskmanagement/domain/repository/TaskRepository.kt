package com.example.taskmanagement.domain.repository

import com.example.taskmanagement.domain.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
}