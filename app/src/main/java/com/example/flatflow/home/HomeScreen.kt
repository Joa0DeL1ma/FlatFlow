package com.example.flatflow.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
        Column(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
                    .fillMaxWidth()
                    .heightIn(min = 300.dp)
                    .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                IconButton(
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "Touch to delete card from bulletin board",
                            tint = Color.Gray,
                        )
                    },
                    onClick = { /*TODO*/ },
                )
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Bulletin Board",
                )
                IconButton(
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Touch to add a card to the bulletin board",
                            tint = Color.Gray,
                        )
                    },
                    onClick = { /*TODO*/ },
                )
            }
            LazyRow {
//
            }
        }
        Column(
            modifier =
                Modifier
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .heightIn(150.dp)
                    .fillMaxWidth()
                    .background(Color.White),
        ) {
            Row(
                modifier = Modifier.padding(start = 12.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(fontSize = 16.sp, fontWeight = FontWeight.Bold, text = "Cleaning Calendar")
                Row {
                    IconButton(
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = "Touch to delete card from bulletin board",
                                tint = Color.Gray,
                            )
                        },
                        onClick = { /*TODO*/ },
                    )
                    IconButton(
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = "Touch to add a card to the bulletin board",
                                tint = Color.Gray,
                            )
                        },
                        onClick = { /*TODO*/ },
                    )
                }
            }
            LazyRow {
                (cleaningCardMock)
            }
        }
        Column(
            modifier =
            Modifier
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .heightIn(150.dp)
                .fillMaxWidth()
                .background(Color.White),
        ) {
            Row(
                modifier = Modifier.padding(start = 12.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(fontSize = 16.sp, fontWeight = FontWeight.Bold, text = "Bills Calendar")
                Row {
                    IconButton(
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = "Touch to delete card from bulletin board",
                                tint = Color.Gray,
                            )
                        },
                        onClick = { /*TODO*/ },
                    )
                    IconButton(
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = "Touch to add a card to the bulletin board",
                                tint = Color.Gray,
                            )
                        },
                        onClick = { /*TODO*/ },
                    )
                }
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
