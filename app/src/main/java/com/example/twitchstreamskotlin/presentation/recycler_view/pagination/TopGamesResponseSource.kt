package com.example.twitchstreamskotlin.presentation.recycler_view.pagination

import android.util.Log
import androidx.paging.PositionalDataSource
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class TopGamesResponseSource(val getFromServerUseCase: GetFromServerUseCase, val repository: DataRepository, val publishSubject: PublishSubject<Throwable>): PositionalDataSource<GameData>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<GameData>) {
        getFromServerUseCase.getTwitchStreamLimit(limit = params.pageSize, offset = params.requestedStartPosition)
            .subscribe({
                       callback.onResult(it, 0)
                saveGamesData(it)
            },{
                publishSubject.onNext(it)
            })
            .dispose()
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<GameData>) {
        getFromServerUseCase.getTwitchStreamLimit(limit = params.loadSize, offset = params.startPosition)
            .subscribe({
                callback.onResult(it)
                saveGamesData(it)
            },{
                publishSubject.onNext(it)
            }).dispose()
    }

    private fun saveGamesData(listGames: List<GameData>) {
        repository.saveGames(listGames)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, {}).dispose()
    }

}