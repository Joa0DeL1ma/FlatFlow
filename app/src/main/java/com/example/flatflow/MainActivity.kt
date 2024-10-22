package com.example.flatflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flatflow.home.HomeScreen
import com.example.flatflow.login.EnterRepublicScreen
import com.example.flatflow.login.LoadingScreen
import com.example.flatflow.login.LoginScreen
import com.example.flatflow.login.RegisterScreen
import com.example.flatflow.ui.theme.FlatFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlatFlowTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("register") { RegisterScreen(navController) }
                    composable("enterRepublic") { EnterRepublicScreen(navController) }
                    composable("home") { HomeScreen(navController) }

                    // Rota para a tela de loading com parâmetros
                    composable("loading/{time}/{destination}") { backStackEntry ->
                        // Recupera os parâmetros da navegação
                        val time = backStackEntry.arguments?.getString("time")?.toIntOrNull() ?: 0
                        val destination = backStackEntry.arguments?.getString("destination") ?: "login"

                        // Chama a tela de loading passando os parâmetros
                        LoadingScreen(
                            navController = navController,
                            time = time,
                            destination = destination,
                        )
                    }
                }
            }
        }
    }
}
