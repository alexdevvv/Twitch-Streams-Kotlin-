package com.example.twitchstreamskotlin.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDataDao {

    @Query("SELECT * FROM gamedataentity")
    fun getAll(): List<GameDataEntity>?

    @Insert
    fun insert(gameDataTablesList: List<GameDataEntity>)
}