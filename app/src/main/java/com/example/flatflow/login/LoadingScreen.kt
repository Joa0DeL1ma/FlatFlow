@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.flatflow.login

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
import com.example.flatflow.R
import kotlinx.coroutines.delay

@Suppress("ktlint:standard:function-naming")
@Composable
fun LoadingScreen(
    navController: NavHostController,
    time: Int,
    destination: String,
) {
    // Lottie Animation
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_animation))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    // Delayed navigation after 2 seconds
    LaunchedEffect(Unit) {
        delay(time.toLong())
        navController.navigate(destination) {
            popUpTo("loading") { inclusive = true }
        }
    }

    // Tela de carregamento
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color(0xff005BC5)),
        contentAlignment = Alignment.Center,
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(150.dp),
        )
    }
}
