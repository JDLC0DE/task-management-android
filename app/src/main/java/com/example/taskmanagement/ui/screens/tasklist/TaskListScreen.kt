package com.example.taskmanagement.ui.screens.tasklist

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.components.CardItem
import com.example.taskmanagement.ui.components.TopBar
import com.example.taskmanagement.ui.theme.TaskTheme
import com.example.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun TaskListScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = TaskTheme.colors.background,
        contentColor = TaskTheme.colors.neutral10,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { print("Hello") },
                containerColor = TaskTheme.colors.primary40,
                contentColor = TaskTheme.colors.neutral10,
                shape = CircleShape
            ) {
                Icon(painterResource(R.drawable.ic_add), "add")
            }
        },
        topBar = { TopBar() }
    ) { innerPadding ->
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(21.dp),
            contentPadding = PaddingValues(horizontal = 21.dp)
        ) {

            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(21.dp)
                ) {

                    Text(
                        text = "Working (02)",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(21.dp)
                    ) {
                        CardItem()
                        CardItem()
                    }
                }
            }

            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(21.dp)
                ) {

                    Text(
                        text = "In Progress (03)",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(21.dp)
                    ) {
                        CardItem()
                        CardItem()
                        CardItem()
                    }
                }
            }

            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(21.dp)
                ) {

                    Text(
                        text = "Done (01)",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(21.dp)
                    ) {
                        CardItem()
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TaskListPreview() {
    TaskManagementTheme(darkTheme = true) {
        TaskListScreen()
    }
}