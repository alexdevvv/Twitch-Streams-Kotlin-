package com.example.twitchstreamskotlin.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GameDataDao {

    @Query("SELECT * FROM gamedataentity")
    fun getAll(): Single<List<GameDataEntity>>

    @Insert(onConflict = REPLACE)
    fun insert(gameDataTablesList: List<GameDataEntity>): Completable


}