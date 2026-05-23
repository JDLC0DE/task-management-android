package com.example.taskmanagement.features.tasklist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.core.ui.components.CardItem
import com.example.taskmanagement.domain.model.Task

@Composable
fun TaskColumn(title: String, tasks: List<Task>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(21.dp)
    ) {

        Text(
            text = "$title (${tasks.size.toString().padStart(2, '0')})",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(21.dp)
        ) {
            items(tasks) { task ->
                CardItem(title = task.name)
            }
        }
    }
}
