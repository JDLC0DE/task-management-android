package com.example.taskmanagement.data.remote.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.example.taskmanagement.domain.model.TaskStatus
import com.example.taskmanagement.graphql.GetTasksQuery
import com.example.taskmanagement.graphql.type.FilterTaskInput
import com.example.taskmanagement.graphql.type.Status
import javax.inject.Inject

class TaskRemoteDataSource @Inject constructor(
    private val apolloClient: ApolloClient
) {
    suspend fun getTasks(status: TaskStatus? = null): List<GetTasksQuery.Task> {
        val filterStatus = status?.let {
            Optional.present(Status.valueOf(it.name))
        } ?: Optional.absent()

        val response = apolloClient
            .query(GetTasksQuery(FilterTaskInput(status = filterStatus)))
            .execute()

        return response.data?.tasks ?: emptyList()
    }
}