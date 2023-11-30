package com.example.twoforyou_boardgamedb.screen.db

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twoforyou_boardgamedb.model.Boardgame
import com.example.twoforyou_boardgamedb.repository.BoardgameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class DbScreenViewModel @Inject constructor(
    private val repository: BoardgameRepository
): ViewModel() {

    private val _boardgameList = MutableStateFlow<List<Boardgame>>(emptyList())
    val boardgameList = _boardgameList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBoardgame().distinctUntilChanged()
                .collect { boardgameList ->
                    _boardgameList.value = boardgameList
                }
        }
    }

    fun getBoardgame() = repository.getBoardgame()

    fun insertBoardgame(boardgame: Boardgame) = viewModelScope.launch {
        repository.insertBoardgame(boardgame)
    }

    fun updateBoardgame(boardgame: Boardgame) = viewModelScope.launch {
        repository.updateBoardgame(boardgame)
    }

    fun deleteAllBoardgame() = viewModelScope.launch {
        repository.deleteAllBoardgame()
    }

    fun deleteBoardgame(boardgame: Boardgame) = viewModelScope.launch {
        repository.deleteBoardgame(boardgame)
    }

    fun addBoardgameToDb(url : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val docs = Jsoup
                .connect(url)
                .maxBodySize(0)
                .timeout(60000)
                .get()
            val title = docs.select("h1")
            Log.d(TAG, "addBoardgameToDb: $docs")
        }

    }

}