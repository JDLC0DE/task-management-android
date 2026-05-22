package com.example.taskmanagement.data.remote.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.example.taskmanagement.graphql.GetTasksQuery
import com.example.taskmanagement.graphql.type.FilterTaskInput
import com.example.taskmanagement.graphql.type.Status
import javax.inject.Inject

class TaskRemoteDataSource @Inject constructor(
    private val apolloClient: ApolloClient
) {
    suspend fun getTasks(): List<GetTasksQuery.Task> {
        val response = apolloClient
            .query(GetTasksQuery(FilterTaskInput(status = Optional.present(Status.TODO))))
            .execute()

        return response.data?.tasks ?: emptyList()
    }
}