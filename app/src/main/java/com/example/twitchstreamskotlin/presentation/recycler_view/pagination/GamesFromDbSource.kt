package com.example.twitchstreamskotlin.presentation.recycler_view.pagination

import androidx.paging.PositionalDataSource
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.model.GameData

class GamesFromDbSource(val getFromDBUseCase: GetFromDBUseCase): PositionalDataSource<GameData>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<GameData>) {
        getFromDBUseCase.getGamesLimited(limit = params.pageSize, offset = params.requestedStartPosition)
            .subscribe({
                callback.onResult(it, 0)
            },{}).dispose()
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<GameData>) {
        getFromDBUseCase.getGamesLimited(limit = params.loadSize, offset = params.startPosition)
            .subscribe({
                   callback.onResult(it)
            },{}).dispose()
    }
}