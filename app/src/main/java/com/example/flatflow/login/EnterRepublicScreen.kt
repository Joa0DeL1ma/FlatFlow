package com.example.flatflow.login

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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flatflow.R

// TODO ajustar cores do textField`s,

@Suppress("ktlint:standard:function-naming")
@Composable
fun EnterRepublicScreen(navController: NavHostController) {
    var insertCodeError by remember { mutableStateOf(false) }

    Column(
        modifier =
            Modifier
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
                label = { Text(text = "Code...") },
                trailingIcon =
                    {
                        IconButton(
                            onClick = { /*TODO*/ },
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_login),
                                    contentDescription = "",
                                )
                            },
                        )
                    },
            )
        }
        // TODO Realizar verificaçao de retorno do back, caso o código não bata com
        // TODO nenhum código de república, ele mudara o insertCodeError para true
        if (insertCodeError) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "* Enter correct code",
                color = Color.Yellow,
            )
        }
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
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
                Text(fontSize = 16.sp, text = "Enter")
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
                Text(fontSize = 16.sp, text = "Create republic")
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview
@Composable
private fun EnterRepublicScreenPreview() {
    MaterialTheme {
        EnterRepublicScreen(navController = rememberNavController())
    }
}
