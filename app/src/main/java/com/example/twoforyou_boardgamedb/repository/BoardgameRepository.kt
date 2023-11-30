package com.example.twoforyou_boardgamedb.repository

import com.example.twoforyou_boardgamedb.database.BoardgameDao
import com.example.twoforyou_boardgamedb.model.Boardgame
import javax.inject.Inject

class BoardgameRepository @Inject constructor(
    private val boardgameDao: BoardgameDao
) {

    fun getBoardgame() =
        boardgameDao.getBoardgame()

    suspend fun insertBoardgame(boardgame: Boardgame) =
        boardgameDao.insertBoardgame(boardgame)

    suspend fun updateBoardgame(boardgame: Boardgame) =
        boardgameDao.updateBoardgame(boardgame)

    suspend fun deleteAllBoardgame() =
        boardgameDao.deleteAllBoardgame()

    suspend fun deleteBoardgame(boardgame: Boardgame) =
        boardgameDao.deleteBoardgame(boardgame)

}