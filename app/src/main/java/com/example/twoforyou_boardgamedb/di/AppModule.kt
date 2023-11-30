package com.example.twoforyou_boardgamedb.di

import android.content.Context
import androidx.room.Room
import com.example.twoforyou_boardgamedb.database.BoardgameDao
import com.example.twoforyou_boardgamedb.database.BoardgameDatabase
import com.example.twoforyou_boardgamedb.model.Boardgame
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesBoardgame(boardgameDatabase: BoardgameDatabase) : BoardgameDao =
        boardgameDatabase.boardgameDao()

    @Singleton
    @Provides
    fun providesBoardgameDatabase(@ApplicationContext context : Context) : BoardgameDatabase =
        Room.databaseBuilder(
            context,
            BoardgameDatabase::class.java,
            "boardgame_database"
        )
            .fallbackToDestructiveMigration()
            .build()

}