package com.example.twoforyou_boardgamedb.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.twoforyou_boardgamedb.model.Boardgame
import kotlinx.coroutines.flow.Flow

@Dao
interface BoardgameDao {


    @Query("SELECT * FROM boardgame_table")
    fun getBoardgame(): Flow<List<Boardgame>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoardgame(boardgame: Boardgame)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBoardgame(boardgame: Boardgame)

    @Query("DELETE from boardgame_table")
    suspend fun deleteAllBoardgame()

    @Delete
    suspend fun deleteBoardgame(boardgame: Boardgame)

}