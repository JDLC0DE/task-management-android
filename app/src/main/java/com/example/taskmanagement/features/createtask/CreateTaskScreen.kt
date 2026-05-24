package com.example.taskmanagement.features.createtask

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.components.atoms.InputField
import com.example.taskmanagement.core.ui.theme.TaskManagementTheme
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun CreateTaskScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = TaskTheme.colors.background,
        contentColor = TaskTheme.colors.neutral10,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(top = 10.dp, start = 21.dp, end = 21.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(32.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = TaskTheme.colors.neutral20
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(R.drawable.ic_close),
                        contentDescription = "close"
                    )
                }

                TextButton(
                    onClick = { print("Hello") },
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = TaskTheme.colors.neutral20,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    )
                ) {
                    Text(text = "Create", fontSize = 20.sp, fontWeight = FontWeight.Normal)
                }
            }

            InputField(value = "", onValueChange = {}, placeholder = "Task Title")


        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CreateTaskScreenPreview() {
    TaskManagementTheme(darkTheme = true) {
        CreateTaskScreen()
    }
}