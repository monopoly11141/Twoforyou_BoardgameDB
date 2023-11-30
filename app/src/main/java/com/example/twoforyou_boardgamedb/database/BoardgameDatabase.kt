package com.example.twoforyou_boardgamedb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.twoforyou_boardgamedb.model.Boardgame

@Database(
    entities = [Boardgame::class],
    version = 1,
    exportSchema = false
)
abstract class BoardgameDatabase : RoomDatabase() {

    abstract fun boardgameDao() : BoardgameDao

}