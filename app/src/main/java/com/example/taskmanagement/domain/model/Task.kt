package com.example.taskmanagement.domain.model

data class Task(
    val id: String,
    val name: String,
    val pointEstimate: String,
    val tags: List<String>,
    val dueDate: String,
    val status: String,
    val assigneeName: String?,
    val creatorName: String
)