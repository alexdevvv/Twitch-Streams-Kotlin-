package com.example.twitchstreamskotlin.presentation.recycler_view.pagination

import androidx.paging.DataSource
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import com.example.twitchstreamskotlin.model.GameData
import com.example.twitchstreamskotlin.presentation.recycler_view.pagination.TopGamesResponseSource
import io.reactivex.subjects.PublishSubject


class TopGamesSourceFactory(val getFromServerUseCase: GetFromServerUseCase, val repository: DataRepository): DataSource.Factory<Int, GameData>() {

    val publishSubject: PublishSubject<Throwable> = PublishSubject.create()
    override fun create(): DataSource<Int, GameData> {
        return TopGamesResponseSource(getFromServerUseCase = getFromServerUseCase, repository = repository, publishSubject = publishSubject)
    }
}