package com.example.flatflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(modifier: Modifier, navController: NavHostController) {
    // Lottie Animation
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_animation))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    // Delayed navigation after 2 seconds
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("nextScreen") {
            popUpTo("loading") { inclusive = true }  // Remove a tela de carregamento da pilha
        }
    }

    // Tela de carregamento
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xff005BC5)),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(150.dp)
        )
    }
}
