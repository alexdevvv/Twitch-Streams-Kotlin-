package com.example.twitchstreamskotlin.domain

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Single


class GetFromServerUseCase(val dataRepository: DataRepository) {

    fun getGames(): Single<List<GameData>> {
        return dataRepository.getData()
    }

    fun insertGames() {

    }
}