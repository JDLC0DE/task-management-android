package com.example.taskmanagement.data.repository

import com.example.taskmanagement.data.mapper.toDomain
import com.example.taskmanagement.data.remote.datasource.TaskRemoteDataSource
import com.example.taskmanagement.domain.model.Task
import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val remoteDataSource: TaskRemoteDataSource
) : TaskRepository {

    override suspend fun getTasks(status: TaskStatus?): List<Task> {
        return remoteDataSource
            .getTasks(status)
            .map { it.toDomain() }
    }
}