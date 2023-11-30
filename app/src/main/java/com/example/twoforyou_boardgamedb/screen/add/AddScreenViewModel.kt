package com.example.twoforyou_boardgamedb.screen.add

import androidx.lifecycle.ViewModel
import com.example.twoforyou_boardgamedb.repository.BoardgameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val repository: BoardgameRepository
) : ViewModel() {
}