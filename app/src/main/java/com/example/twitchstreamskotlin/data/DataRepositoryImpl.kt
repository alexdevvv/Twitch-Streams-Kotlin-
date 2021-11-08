package com.example.twitchstreamskotlin.data

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.data.retrofit.TwitchStreamAPI
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import io.reactivex.Single

class DataRepositoryImpl(val api: TwitchStreamAPI): DataRepository {

    override fun getData(): Single<List<GameDataModel>> {

        return api.getTwitchStream().map {
            it.top!!.map { GameDataModel.getGameDataModelFromTop(it) }
        }
    }

    override fun saveData() {
    }


}