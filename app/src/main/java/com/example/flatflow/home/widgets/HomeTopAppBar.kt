package com.example.flatflow.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flatflow.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            modifier = Modifier.size(72.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            tint = Color.White,
        )
        Row(
            Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                color = Color(0xff005BC5),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 8.dp),
                text = "Code: ",
                fontSize = 20.sp,
            )
            Text(
                fontWeight = FontWeight.Bold,
                color = Color(0xff005BC5),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 8.dp),
                text = "X23FG",
                fontSize = 20.sp,
            )
        }
        Icon(
            modifier = Modifier.size(56.dp),
            painter = painterResource(id = R.drawable.ic_group),
            contentDescription = "Participants",
            tint = Color.White,
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview
@Composable
private fun HomeTopAppBarPreview() {
    HomeTopAppBar()
}
