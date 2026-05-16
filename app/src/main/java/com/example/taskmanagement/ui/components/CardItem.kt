package com.example.taskmanagement.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.TaskTheme

@Composable
fun CardItem() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(11.dp))
            .background(TaskTheme.colors.neutral40)
            .width(345.dp)
            .height(240.dp)
            .padding(21.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Card Item",
                color = TaskTheme.colors.neutral10,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_more),
                    contentDescription = "options",
                    tint = TaskTheme.colors.neutral20
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "3 Pts",
                color = TaskTheme.colors.neutral10,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Tag("Today", type = TagType.WHITE, icon = painterResource(R.drawable.ic_alarm))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
            Tag("IOS App", type = TagType.SUCCESS)
            Tag("Android", type = TagType.WARNING)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Avatar("https://picsum.photos/200")

            Row(horizontalArrangement = Arrangement.spacedBy(21.dp)) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(21.dp),
                ) {
                    Icon(
                        modifier = Modifier.size(21.dp),
                        painter = painterResource(R.drawable.ic_clip),
                        contentDescription = "clip",
                        tint = TaskTheme.colors.neutral10
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "5", fontSize = 20.sp, fontWeight = FontWeight.Normal, color = TaskTheme.colors.neutral10)
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(21.dp),
                    ) {
                        Icon(
                            modifier = Modifier.size(21.dp),
                            painter = painterResource(R.drawable.ic_tree),
                            contentDescription = "tree",
                            tint = TaskTheme.colors.neutral10
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "3", fontSize = 20.sp, fontWeight = FontWeight.Normal, color = TaskTheme.colors.neutral10)
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(21.dp),
                    ) {
                        Icon(
                            modifier = Modifier.size(21.dp),
                            painter = painterResource(R.drawable.ic_comment),
                            contentDescription = "tree",
                            tint = TaskTheme.colors.neutral10
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardItemPreview() {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CardItem()
    }
}