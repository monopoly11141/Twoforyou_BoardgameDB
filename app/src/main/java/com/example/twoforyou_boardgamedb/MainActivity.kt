package com.example.twoforyou_boardgamedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.twoforyou_boardgamedb.navigation.Navigation
import com.example.twoforyou_boardgamedb.ui.theme.Twoforyou_BoardgameDBTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Twoforyou_BoardgameDBTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}