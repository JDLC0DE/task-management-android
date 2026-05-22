package com.example.taskmanagement.core.network

import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.apollographql.apollo.network.http.HttpInterceptor
import com.apollographql.apollo.network.http.HttpInterceptorChain

class AuthInterceptor(
    private val tokenProvider: () -> String?
) : HttpInterceptor {

    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain
    ): HttpResponse {
        val token = tokenProvider()

        val newRequest = request.newBuilder()
            .apply {
                if (!token.isNullOrEmpty()) {
                    addHeader(
                        NetworkConstants.AUTH_HEADER,
                        "${NetworkConstants.BEARER} $token"
                    )
                }
            }
            .build()

        return chain.proceed(newRequest)
    }
}