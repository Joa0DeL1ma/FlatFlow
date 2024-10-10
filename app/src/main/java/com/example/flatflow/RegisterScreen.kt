package com.example.flatflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//TODO ajustar cores do textField`s,

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Column(
        modifier =
        modifier
            .fillMaxSize()
            .background(Color(color = 0xff005BC5))
            .padding(horizontal = 48.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier.size(130.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                tint = Color.White,
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = { Text(text = "Email") },
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = { Text(text = "Password") },
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = { Text(text = "Repeat Password") },
            )
        }
        Text(
            modifier = Modifier.padding(top = 4.dp),
            color = Color.Gray,
            text = "* Minimum 8 char`s")
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors =
                ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                ),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                shape = RoundedCornerShape(6.dp),
                onClick = { /*TODO*/ },
            ) {
                Text(fontSize = 16.sp, text = "Register Account")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors =
                ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                ),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                shape = RoundedCornerShape(6.dp),
                onClick = { /*TODO*/ },
            ) {
                Text(fontSize = 16.sp, text = "Login")
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    MaterialTheme {
        RegisterScreen()
    }
}
