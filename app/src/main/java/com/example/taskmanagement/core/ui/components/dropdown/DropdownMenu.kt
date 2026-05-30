package com.example.taskmanagement.core.ui.components.dropdown

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu as MaterialDropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun DropdownMenu(
    expanded: Boolean,
    onClose: () -> Unit,
    label: String? = null,
    content: @Composable () -> Unit
) {
    MaterialDropdownMenu(
        modifier = Modifier.padding(vertical = 10.dp),
        containerColor = TaskTheme.colors.neutral30,
        border = BorderStroke(width = 1.dp, color = TaskTheme.colors.neutral20),
        shape = RoundedCornerShape(10.dp),
        expanded = expanded,
        onDismissRequest = onClose
    ) {
        if (label != null) {
            Box(modifier = Modifier.padding(horizontal = 21.dp)) {
                Text(
                    text = label,
                    fontSize = 27.sp,
                    color = TaskTheme.colors.neutral20,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        content()
    }
}
