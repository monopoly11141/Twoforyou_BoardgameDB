package com.example.twoforyou_boardgamedb.screen.db

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DbScreen(
    navController: NavController,
    viewModel: DbScreenViewModel = hiltViewModel()
) {

    var searchQuery by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SearchBar(
                query = searchQuery,
                onQueryChange = {
                    searchQuery = it
                },
                onSearch = {
                    searchActive = false
                },
                active = searchActive,
                onActiveChange = {
                    searchActive = it
                },
                leadingIcon = {
                    IconButton(
                        onClick = { viewModel.addBoardgameToDb(searchQuery) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add ,
                            contentDescription = "추가하기",
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search ,
                            contentDescription = "검색하기",
                        )
                    }
                },

            ) {
            }
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(it)
        ) {
            items(viewModel.boardgameList.value.size) { index ->
                Text(viewModel.boardgameList.collectAsState().value[index].name)
            }
        }


    }
}