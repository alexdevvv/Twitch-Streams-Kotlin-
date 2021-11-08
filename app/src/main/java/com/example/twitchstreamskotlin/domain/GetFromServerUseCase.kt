package com.example.twitchstreamskotlin.domain

import com.example.twitchstreamskotlin.data.DataRepositoryImpl
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import io.reactivex.Single
import java.time.format.SignStyle


class GetFromServerUseCase(val dataRepository: DataRepository) {

    fun getGames(): Single<List<GameDataModel>> {
        return dataRepository.getData()
    }

    fun insertGames() {

    }
}