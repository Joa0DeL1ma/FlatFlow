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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flatflow.model.mockUsers

//TODO ajustar cores do textField`s,

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    //todo viewmodel aqui
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var enableWrongLoginAlert by remember { mutableStateOf(false) }
    fun verifyLogin(email: String, password: String): Boolean {
        return mockUsers.any { mockUser ->
            mockUser.email == email && mockUser.password == password
        }
    }
    //todo
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
                contentDescription = "FlatFlow Logo",
                tint = Color.White,
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation()
            )
        }
        if (enableWrongLoginAlert) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "* Wrong email or password",
                color = Color.Yellow
            )
        }
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
                onClick = {
                    if (verifyLogin(email, password)) {
                        navController.navigate("loading")
                    } else {
                        enableWrongLoginAlert = true
                    }
                },
            ) {
                Text(fontSize = 16.sp, text = "Login")
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
                onClick = { /*TODO colocar navigation para tela de register aqui*/ },
            ) {
                Text(fontSize = 16.sp, text = "Register")
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
