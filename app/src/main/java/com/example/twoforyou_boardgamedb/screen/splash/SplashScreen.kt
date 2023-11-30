package com.example.twoforyou_boardgamedb.screen.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.twoforyou_boardgamedb.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    Text("Splash Screen")
    
    LaunchedEffect(
        key1 = true,
        block = {
            delay(700L)
            navController.navigate(route = Screen.DbScreen.route)
        }
    )

}