package com.example.twoforyou_boardgamedb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boardgame_table")
data class Boardgame(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val ranking: Int?,
    val rating: Double?,
    val weight: Double?,
    val playerCount: String
)