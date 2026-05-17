package com.example.taskmanagement.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagement.features.createtask.CreateTaskScreen
import com.example.taskmanagement.features.tasklist.TaskListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.TaskListScreen.route) {
        composable(route = Routes.TaskListScreen.route) {
            TaskListScreen(onNavigateToCreateTask = {
                navController.navigate(route = Routes.CreateTaskScreen.route)
            })
        }

        composable(route = Routes.CreateTaskScreen.route) {
            CreateTaskScreen()
        }

        composable(route = Routes.EditTaskScreen.route) {
            // EditTaskScreen()
        }
    }
}