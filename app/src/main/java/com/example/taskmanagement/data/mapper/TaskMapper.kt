package com.example.taskmanagement.data.mapper

import com.example.taskmanagement.core.utils.DateUtils
import com.example.taskmanagement.core.ui.components.atoms.TagType
import com.example.taskmanagement.domain.model.Assignee
import com.example.taskmanagement.domain.model.PointEstimate
import com.example.taskmanagement.domain.model.Task
import com.example.taskmanagement.domain.model.TaskTag
import com.example.taskmanagement.graphql.GetTasksQuery
import com.example.taskmanagement.graphql.type.PointEstimate as ApolloPointEstimate
import com.example.taskmanagement.graphql.type.TaskTag as ApolloTaskTag

fun ApolloPointEstimate.toDomain(): PointEstimate {
    val label = when (this) {
        ApolloPointEstimate.EIGHT -> "8"
        ApolloPointEstimate.FOUR -> "4"
        ApolloPointEstimate.TWO -> "2"
        ApolloPointEstimate.ONE -> "1"
        ApolloPointEstimate.ZERO -> "0"
        else -> "0"
    }
    return PointEstimate(value = this.name, label = label)
}

fun ApolloTaskTag.toDomain(): TaskTag {
    val type = when (this) {
        ApolloTaskTag.ANDROID -> TagType.WARNING
        ApolloTaskTag.IOS -> TagType.SUCCESS
        ApolloTaskTag.NODE_JS -> TagType.WHITE
        ApolloTaskTag.RAILS -> TagType.PRIMARY
        ApolloTaskTag.REACT -> TagType.WHITE
        else -> TagType.WHITE
    }
    return TaskTag(title = this.name, type = type)
}

fun GetTasksQuery.Task.toDomain(): Task {
    return Task(
        id = id,
        name = name,
        pointEstimate = pointEstimate.toDomain(),
        tags = tags.map { it.toDomain() },
        dueDate = DateUtils.formatDueDate(dueDate.toString()),
        status = status.name,
        assignee = Assignee(name = assignee?.fullName ?: "", avatar = "https://picsum.photos/100"),
        creatorName = creator.fullName
    )
}