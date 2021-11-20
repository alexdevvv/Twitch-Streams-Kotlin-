package com.example.twitchstreamskotlin.domain.repository

import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Completable
import io.reactivex.Single

interface DataRepository {
    
    fun fetchData(): Single<List<GameData>>

    fun getData(): Single<List<GameData>>

    fun saveGames(listData: List<GameData>): Completable
}