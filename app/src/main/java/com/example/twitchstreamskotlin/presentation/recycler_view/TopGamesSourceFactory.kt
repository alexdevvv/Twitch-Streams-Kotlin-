package com.example.twitchstreamskotlin.presentation.recycler_view

import androidx.paging.DataSource
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.model.GameData


class TopGamesSourceFactory(val getFromServerUseCase: GetFromServerUseCase): DataSource.Factory<Int, GameData>() {
    override fun create(): DataSource<Int, GameData> {
        return TopGamesResponseSource(getFromServerUseCase = getFromServerUseCase)
    }
}