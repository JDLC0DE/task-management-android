package com.example.taskmanagement.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun MoreOptions() {
    var expanded by remember { mutableStateOf(false) }

    Box {
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier.size(32.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_more),
                contentDescription = "options",
                tint = TaskTheme.colors.neutral20
            )
        }

        DropdownMenu(
            containerColor = TaskTheme.colors.neutral30,
            border = BorderStroke(width = 1.dp, color = TaskTheme.colors.neutral20),
            shape = RoundedCornerShape(10.dp),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        "Edit",
                        color = TaskTheme.colors.neutral10,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = "edit",
                        tint = TaskTheme.colors.neutral10
                    )
                },
                onClick = {
                    expanded = false
                    /* TODO: Lógica para editar */
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        "Delete",
                        color = TaskTheme.colors.neutral10,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_delete),
                        contentDescription = "delete",
                        tint = TaskTheme.colors.neutral10
                    )
                },
                onClick = {
                    expanded = false
                    /* TODO: Lógica para eliminar */
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoreOptionsPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MoreOptions()
    }
}