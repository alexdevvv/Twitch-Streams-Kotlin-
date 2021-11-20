package com.example.twitchstreamskotlin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameDataEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract val gameDataDao: GameDataDao

}