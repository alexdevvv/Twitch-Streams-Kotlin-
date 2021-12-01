package com.example.twitchstreamskotlin.data

import android.util.Log
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.data.retrofit.TwitchStreamAPI
import com.example.twitchstreamskotlin.data.room.GameDataDao
import com.example.twitchstreamskotlin.data.room.GameDataEntity
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Completable
import io.reactivex.Single

class DataRepositoryImpl(val api: TwitchStreamAPI, val dao: GameDataDao) : DataRepository {

    override fun fetchData(): Single<List<GameData>> {

        return api.getTwitchStream().map {
            it.top!!.map { GameData(GameDataModel.getGameDataModelFromTop(it)) }
        }
    }

    override fun fetchDataLimit(limit: Int, offset: Int): Single<List<GameData>> {
        return api.getTwitchStreamLimit(limit, offset).map { it.top!!.map { GameData(GameDataModel.getGameDataModelFromTop(it)) } }
    }

    override fun getData(): Single<List<GameData>> {
        return dao.getAll().map { it.map { gameDataEntity -> GameData(gameDataEntity) } }
    }

    override fun saveGames(listData: List<GameData>): Completable {
        val list: List<GameDataEntity> = listData.map { GameDataEntity(it) }
        Log.e("saveDataDbObserver", "SaveGames from DataRepositoryImpl ${list.size}")
        return dao.insert(list)
    }


}