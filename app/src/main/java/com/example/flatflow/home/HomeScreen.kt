package com.example.flatflow.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flatflow.home.widgets.HomeTopAppBar

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen() {
    Column(
        modifier =
            Modifier
                .background(Color(0xff005BC5))
                .fillMaxSize()
                .padding(start = 16.dp, top = 12.dp, end = 16.dp),
    ) {
        HomeTopAppBar(modifier = Modifier.padding(bottom = 16.dp))
        Column(modifier = Modifier
            .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
            .fillMaxWidth()
            .heightIn(min = 300.dp)
            .background(Color.White)
            ) {
            IconButton(onClick = { /*TODO*/ }) {
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
