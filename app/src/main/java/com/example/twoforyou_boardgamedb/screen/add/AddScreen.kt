package com.example.twoforyou_boardgamedb.screen.add

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.twoforyou_boardgamedb.navigation.Screen

@Composable
fun AddScreen(
    navController: NavController,
    viewModel : AddScreenViewModel = hiltViewModel()
) {
    Text("Add Screen")
}