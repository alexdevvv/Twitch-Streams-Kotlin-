package com.example.twitchstreamskotlin.domain

import com.example.twitchstreamskotlin.data.retrofit.TwitchResponseMain
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Single


class GetFromServerUseCase(val dataRepository: DataRepository) {

    fun fetchGames(): Single<List<GameData>> {
        return dataRepository.fetchData()
    }

    fun getTwitchStreamLimit(limit: Int, offset: Int):Single<List<GameData>> {
        return dataRepository.fetchDataLimit(limit, offset)
    }

}