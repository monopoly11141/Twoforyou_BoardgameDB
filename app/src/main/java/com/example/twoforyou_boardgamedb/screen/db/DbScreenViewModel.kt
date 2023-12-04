package com.example.twoforyou_boardgamedb.screen.db

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
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
import org.htmlunit.WebClient
import org.htmlunit.html.HtmlPage
import org.jsoup.Jsoup
import java.io.File
import javax.inject.Inject


@HiltViewModel
class DbScreenViewModel @Inject constructor(
    private val repository: BoardgameRepository
) : ViewModel() {

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

    @SuppressLint("SetJavaScriptEnabled")
    fun addBoardgameToDb(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .get()

            Log.d(TAG, "addBoardgameToDb: $document")

        }

    }

}