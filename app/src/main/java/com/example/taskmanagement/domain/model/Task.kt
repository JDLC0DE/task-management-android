package com.example.taskmanagement.domain.model

import com.example.taskmanagement.core.ui.components.atoms.TagType

data class TaskTag(val title: String, val type: TagType)

data class PointEstimate(val value: String, val label: String)

data class Assignee(val name: String, val avatar: String)

data class Task(
    val id: String,
    val name: String,
    val pointEstimate: PointEstimate,
    val tags: List<TaskTag>,
    val dueDate: String,
    val status: String,
    val assignee: Assignee,
    val creatorName: String
)