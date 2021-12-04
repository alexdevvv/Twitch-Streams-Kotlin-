package com.example.twitchstreamskotlin.domain

import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Completable
import io.reactivex.Single

class GetFromDBUseCase(private val dataRepository: DataRepository) {

    fun getGames(): Single<List<GameData>>{
        return dataRepository.getData()
    }

    fun saveGames(listData: List<GameData>): Completable {
       return dataRepository.saveGames(listData)
    }

    fun getGamesLimited(limit: Int, offset: Int): Single<List<GameData>> {
        return dataRepository.getDataLimited(limit, offset)
    }


}