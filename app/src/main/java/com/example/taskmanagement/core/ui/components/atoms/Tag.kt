package com.example.taskmanagement.core.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.core.ui.theme.TaskTheme

enum class TagType {
    WHITE,
    SUCCESS,
    WARNING,
    PRIMARY,
}

@Composable
fun Tag(title: String, type: TagType = TagType.PRIMARY, icon: Painter? = null) {
    val color = when (type) {
        TagType.WHITE -> TaskTheme.colors.neutral10
        TagType.SUCCESS -> TaskTheme.colors.secondary40
        TagType.WARNING -> TaskTheme.colors.tertiary40
        TagType.PRIMARY -> TaskTheme.colors.primary40
    }

    Row(
        modifier = Modifier
            .background(color.copy(0.1f), shape = RoundedCornerShape(5.dp))
            .padding(21.dp, 5.dp)
    ) {
        if (icon != null) {
            Icon(painter = icon, contentDescription = "icon", tint = color)
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = title.uppercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TagPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Tag("Label", icon = painterResource(R.drawable.ic_notifications))
    }
}