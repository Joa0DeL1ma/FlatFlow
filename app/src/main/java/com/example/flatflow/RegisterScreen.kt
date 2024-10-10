package com.example.flatflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flatflow.ui.theme.FlatFlowTheme

// TODO ajustar cores do textField`s,

@Suppress("ktlint:standard:function-naming")
@Composable
fun RegisterScreen(
    navController: NavHostController,
) {
    var enableMinCharAlert by remember { mutableStateOf(false) }
    var enablePasswordWontMatchAlert by remember { mutableStateOf(false) }
    var enableRegisterButton by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

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
                value = email,
                onValueChange = { email = it
                    if (email != "") {
                        if (password != "" && repeatPassword != "") {
                            enableRegisterButton = true
                        }
                    }
                    else {
                        enableRegisterButton = false
                    }},
                label = { Text(text = "Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = {
                    password = it
                    if (it.length <= 8) {
                        enableMinCharAlert = true
                    }
                    if (password != "") {
                        if (email != "" && repeatPassword != "") {
                            enableRegisterButton = true
                        }
                    }
                    else {
                        enableRegisterButton = false
                    }
                },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = repeatPassword,
                onValueChange = {
                    repeatPassword = it
                    if (it.length < 8) {
                        enableRegisterButton = false
                    }
                    if (repeatPassword.length >= 8) {
                        if (email != "" && password != "") {
                            enableRegisterButton = true
                        }
                    }
                    else {
                        enableRegisterButton = false
                    }
                },
                label = { Text(text = "Repeat Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
        if (enableMinCharAlert) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                color = Color.Yellow,
                text = "* Minimum 8 char`s",
            )
        }
        if (enablePasswordWontMatchAlert) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "* Password wont match",
                color = Color.Yellow,
            )
        }
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = enableRegisterButton,
                colors =
                    ButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                    ),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                shape = RoundedCornerShape(6.dp),
                onClick = {
                    if (password != repeatPassword) {
                        enablePasswordWontMatchAlert = true
                    } else if (email != "" && repeatPassword.length >= 8) {
                        navController.navigate("loading/2000/enterRepublic")
                    }
                },
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
                onClick = { navController.navigate("loading/1000/login") },
            ) {
                Text(fontSize = 16.sp, text = "Login")
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview
@Composable
private fun RegisterScreenPreview() {
    FlatFlowTheme {
        RegisterScreen(navController = rememberNavController())
    }
}
