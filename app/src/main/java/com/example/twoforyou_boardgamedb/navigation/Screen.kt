package com.example.twoforyou_boardgamedb.navigation

sealed class Screen(val route: String) {
    object AddScreen : Screen(route = "add_screen")
    object DbScreen : Screen(route = "db_screen")
    object SplashScreen : Screen(route = "splash_screen")
}
