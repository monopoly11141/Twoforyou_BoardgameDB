package com.example.twoforyou_boardgamedb.screen.db

import androidx.lifecycle.ViewModel
import com.example.twoforyou_boardgamedb.repository.BoardgameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DbScreenViewModel @Inject constructor(
    private val repository: BoardgameRepository
): ViewModel() {


}