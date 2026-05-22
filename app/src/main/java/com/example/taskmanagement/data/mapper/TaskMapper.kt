package com.example.taskmanagement.data.mapper

import com.example.taskmanagement.graphql.GetTasksQuery
import com.example.taskmanagement.domain.model.Task

fun GetTasksQuery.Task.toDomain(): Task {
    return Task(
        id = id,
        name = name,
        pointEstimate = pointEstimate.toString(),
        tags = tags.map { it.toString() },
        dueDate = dueDate.toString(),
        status = status.toString(),
        assigneeName = assignee?.fullName,
        creatorName = creator.fullName
    )
}