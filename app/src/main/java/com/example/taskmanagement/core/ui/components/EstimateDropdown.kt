package com.example.taskmanagement.core.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.components.dropdown.DropdownMenu
import com.example.taskmanagement.core.ui.components.dropdown.DropdownTrigger
import com.example.taskmanagement.core.ui.theme.TaskTheme

data class DropdownOption(val label: String, val value: String)

const val EstimateLabel = "Estimate"

@Composable
fun EstimateDropdown(
    selected: DropdownOption? = null,
    onSelect: (currentOption: DropdownOption) -> Unit,
    options: List<DropdownOption>
) {
    var expanded by remember { mutableStateOf(false) }
    val label = if (selected?.label?.isNotEmpty() == true) { selected.label } else { EstimateLabel }
    val showBackground = selected == null

    DropdownTrigger(
        label = label,
        icon = painterResource(R.drawable.ic_point),
        showBackground = showBackground,
        onPress = { expanded = true }
    )

    DropdownMenu(expanded = expanded, onClose = { expanded = false }, label = EstimateLabel) {
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
                    onSelect(option)
                    expanded = false
                }
            )
        }
    }
}
