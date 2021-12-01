package com.example.twitchstreamskotlin.domain.repository

import com.example.twitchstreamskotlin.data.retrofit.TwitchResponseMain
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Completable
import io.reactivex.Single

interface DataRepository {
    
    fun fetchData(): Single<List<GameData>>

    fun fetchDataLimit(limit: Int, offset:Int): Single<List<GameData>>

    fun getData(): Single<List<GameData>>

    fun saveGames(listData: List<GameData>): Completable
}