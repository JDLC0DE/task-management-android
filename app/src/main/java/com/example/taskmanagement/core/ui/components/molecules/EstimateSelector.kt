package com.example.taskmanagement.core.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.theme.TaskTheme

data class DropdownOption(val label: String, val value: String)

@Composable
fun EstimateSelector(onSelect: () -> Unit, options: List<DropdownOption>) {
    var expanded by remember { mutableStateOf(false) }

    SelectorLabel(
        label = "Estimate",
        icon = painterResource(R.drawable.ic_point),
        showBackground = true,
        onPress = { expanded = true }
    )

    DropdownMenu(expanded = expanded, onClose = { expanded = false }, label = "Estimate") {
        options.forEach { option ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = option.label,
                        color = TaskTheme.colors.neutral10,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_point),
                        contentDescription = "edit",
                        tint = TaskTheme.colors.neutral10
                    )
                },
                contentPadding = PaddingValues(horizontal = 21.dp),
                onClick = {
                    onSelect()
                    expanded = false
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EstimateSelectorPreview() {
    Box(modifier = Modifier.fillMaxSize().background(TaskTheme.colors.background).padding(top = 50.dp)) {
        EstimateSelector(
            onSelect = {},
            options = listOf(
                DropdownOption(label = "0 Points", value = "ZERO"),
                DropdownOption(label = "1 Points", value = "ONE"),
                DropdownOption(label = "2 Points", value = "TWO"),
                DropdownOption(label = "4 Points", value = "FOUR"),
                DropdownOption(label = "8 Points", value = "EIGHT"),
            )
        )
    }
}