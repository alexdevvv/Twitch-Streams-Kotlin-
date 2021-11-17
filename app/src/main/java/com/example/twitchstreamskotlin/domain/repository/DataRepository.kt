package com.example.twitchstreamskotlin.domain.repository

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Single

interface DataRepository {
    
    fun getData(): Single<List<GameData>>
    
    fun saveData()
}