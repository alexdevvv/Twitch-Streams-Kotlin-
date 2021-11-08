package com.example.twitchstreamskotlin.domain.repository

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import io.reactivex.Single

interface DataRepository {
    
    fun getData(): Single<List<GameDataModel>>
    
    fun saveData()
}