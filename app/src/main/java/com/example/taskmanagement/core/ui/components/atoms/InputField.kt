package com.example.taskmanagement.core.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.core.ui.theme.TaskTheme

@Composable
fun InputField(value: String, onValueChange: (String) -> Unit, placeholder: String? = null) {
    Box {
        if (value.isEmpty() && placeholder != null) {
            Text(
                text = placeholder,
                color = TaskTheme.colors.neutral20,
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(Color.Transparent),
            textStyle = TextStyle(
                color = TaskTheme.colors.neutral10,
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InputFieldPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InputField(value = "", onValueChange = {}, placeholder = "Placeholder")
    }
}
