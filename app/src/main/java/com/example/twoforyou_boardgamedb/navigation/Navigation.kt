package com.example.twoforyou_boardgamedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.twoforyou_boardgamedb.screen.add.AddScreen
import com.example.twoforyou_boardgamedb.screen.db.DbScreen
import com.example.twoforyou_boardgamedb.screen.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.AddScreen.route) {
            AddScreen(navController = navController)
        }

        composable(route = Screen.DbScreen.route) {
            DbScreen(navController = navController)
        }

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

    }

}