package com.example.twitchstreamskotlin.presentation.recycler_view

import android.util.Log
import androidx.paging.PositionalDataSource
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.model.GameData

class TopGamesResponseSource(val getFromServerUseCase: GetFromServerUseCase): PositionalDataSource<GameData>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<GameData>) {
        getFromServerUseCase.getTwitchStreamLimit(limit = params.pageSize, offset = params.requestedStartPosition)
            .subscribe({
                       callback.onResult(it, 0)
            },{}).dispose()
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<GameData>) {
        getFromServerUseCase.getTwitchStreamLimit(limit = params.loadSize, offset = params.startPosition)
            .subscribe({
                callback.onResult(it)
            },{}).dispose()
    }
}