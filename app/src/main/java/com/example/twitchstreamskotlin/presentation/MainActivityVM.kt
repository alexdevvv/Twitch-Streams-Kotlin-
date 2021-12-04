package com.example.twitchstreamskotlin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.model.GameData
import com.example.twitchstreamskotlin.presentation.recycler_view.pagination.GamesFromDbFactory
import com.example.twitchstreamskotlin.presentation.recycler_view.pagination.TopGamesSourceFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivityVM(

    val getFromDBUseCase: GetFromDBUseCase,
    val topGamesSourceFactory: TopGamesSourceFactory,
    val gamesFromDbFactory: GamesFromDbFactory
) : ViewModel() {
    private var liveDataModel: MutableLiveData<PagedList<GameData>> = MutableLiveData()
    private val disposable = CompositeDisposable()
    private val pagedListConfig = PagedList
        .Config
        .Builder()
        .setEnablePlaceholders(false)
        .setPageSize(20).build()

    init {
        initTopGamesFactory()
        subscribePublishSubject()
    }

    fun liveData() = liveDataModel

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    private fun subscribePublishSubject() {
        disposable.add(topGamesSourceFactory.publishSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                initGamesFromDbFactory()
            }
        )
    }

    private fun initTopGamesFactory() {
        disposable.add(RxPagedListBuilder(topGamesSourceFactory, pagedListConfig)
            .buildObservable()
            .subscribe {
                liveDataModel.postValue(it)
            })
    }

    private fun initGamesFromDbFactory() {
        disposable.add(RxPagedListBuilder(gamesFromDbFactory, pagedListConfig)
            .buildObservable()
            .subscribe {
                liveDataModel.postValue(it)
            })

    }

}