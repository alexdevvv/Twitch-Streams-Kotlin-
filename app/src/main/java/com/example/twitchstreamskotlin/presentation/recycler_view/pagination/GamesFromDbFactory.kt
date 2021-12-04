package com.example.twitchstreamskotlin.presentation.recycler_view.pagination

import androidx.paging.DataSource
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.model.GameData

class GamesFromDbFactory(val getFromDBUseCase: GetFromDBUseCase): DataSource.Factory<Int, GameData>() {
    override fun create(): DataSource<Int, GameData> {
        return GamesFromDbSource(getFromDBUseCase = getFromDBUseCase)
    }
}