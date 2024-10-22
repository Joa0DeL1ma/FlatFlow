package com.example.flatflow.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flatflow.home.CleaningCardsMock

@Suppress("ktlint:standard:function-naming")
@Composable
fun CleaningCard(task: CleaningCardsMock) {
    Column(
        modifier =
            Modifier
                .background(Color.LightGray)
                .size(120.dp)
                .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (task.numberDay != null) {
            Text(text = "${task.numberDay}")
        }
        if (task.dayOfTheWeek != null) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                text = "${task.dayOfTheWeek}",
            )
        }
        Text(text = task.recurrence,)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = task.assigned + ":")
        Text(text = task.task)
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun CleaningCardPreview() {
    val mockTask =
        CleaningCardsMock(
            numberDay = null,
            dayOfTheWeek = "Saturday",
            recurrence = "Weekly",
            assigned = "Susan",
            task = "Wash dishes",
        )
    CleaningCard(task = mockTask)
}
