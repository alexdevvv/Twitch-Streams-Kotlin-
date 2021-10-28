package com.example.twitchstreamskotlin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameDataEntity::class], version = 1)
abstract class  AppDataBase : RoomDatabase() {

    companion object {
        private var appDatabase: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                context,
                AppDataBase::class.java, "database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
        return appDatabase!!
    }}

    abstract fun gameDataDao(): GameDataDao
}