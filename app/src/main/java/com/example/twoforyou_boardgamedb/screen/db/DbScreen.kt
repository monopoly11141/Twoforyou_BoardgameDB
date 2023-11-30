package com.example.twoforyou_boardgamedb.screen.db

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DbScreen(
    navController: NavController,
    viewModel : DbScreenViewModel = hiltViewModel()
) {
    Text("Db Screen")
}