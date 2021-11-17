package com.example.twitchstreamskotlin.di

import androidx.room.Room
import com.example.twitchstreamskotlin.data.room.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module{
    single { Room.databaseBuilder(
        androidContext(),
        AppDataBase::class.java, "database"
    ).fallbackToDestructiveMigration().build() }

    single { get<AppDataBase>().gameDataDao }
}