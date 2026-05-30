package com.example.taskmanagement.core.ui.components.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun DropdownTrigger(
    label: String,
    icon: Painter,
    showBackground: Boolean,
    onPress: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(11.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (showBackground) {
                    TaskTheme.colors.neutral20.copy(alpha = 0.1f)
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(5.dp)
            )
            .clickable { onPress() }
            .padding(vertical = 5.dp, horizontal = 21.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = label,
            tint = TaskTheme.colors.neutral10,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = TaskTheme.colors.neutral10
        )
    }
}

@Preview
@Composable
fun SelectorLabelPreview() {
    Box(modifier = Modifier.padding(top = 50.dp)) {
        DropdownTrigger(
            icon = painterResource(R.drawable.ic_point),
            label = "Label",
            showBackground = false,
            onPress = {
                print("Pressed")
            })
    }
}