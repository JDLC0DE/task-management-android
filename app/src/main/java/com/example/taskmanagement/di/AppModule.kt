package com.example.taskmanagement.di

import com.apollographql.apollo.ApolloClient
import com.example.taskmanagement.core.network.AuthInterceptor
import com.example.taskmanagement.core.network.NetworkConstants
import com.example.taskmanagement.data.repository.TaskRepositoryImpl
import com.example.taskmanagement.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        taskRepositoryImpl: TaskRepositoryImpl
    ): TaskRepository

    companion object {
        @Provides
        @Singleton
        fun provideApolloClient(): ApolloClient {
            return ApolloClient.Builder()
                .serverUrl(NetworkConstants.BASE_URL)
                .addHttpInterceptor(AuthInterceptor {
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwb3NpdGlvbklkIjoiZjQzNWRlNGItNDI5ZS00ZWQ1LTg1NDgtZWQ1YTAyZWJiZjQzIiwicHJvamVjdElkIjoiMDk4NDBiMDktMGUyOC00MmFkLWEwYzgtYzE1OTljZjMyYjJhIiwiZnVsbE5hbWUiOiJKb3NlcGggRnJhbmNpc2NvIERlIExhIENydXogUml2YXMiLCJlbWFpbCI6InJhem9yaWoyMEBnbWFpbC5jb20iLCJpYXQiOjE3MDEyOTY3NTB9.R8I-IC5Dop3pdTiMMOiZ3HNqUm4dXxpBxAjV3nKWb2Y"
                })
                .build()
        }
    }
}