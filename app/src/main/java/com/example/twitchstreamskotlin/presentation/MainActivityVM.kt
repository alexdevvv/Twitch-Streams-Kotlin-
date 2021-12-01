package com.example.twitchstreamskotlin.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.model.GameData
import com.example.twitchstreamskotlin.presentation.recycler_view.TopGamesSourceFactory
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityVM(
    val useCaseGetFromServer: GetFromServerUseCase,
    val getFromDBUseCase: GetFromDBUseCase,
    val topGamesSourceFactory: TopGamesSourceFactory
) : ViewModel() {
    private var liveDataModel: MutableLiveData<PagedList<GameData>> = MutableLiveData()
    private val disposable = CompositeDisposable()
    private val pagedListConfig = PagedList
        .Config
        .Builder()
        .setEnablePlaceholders(false)
        .setPageSize(20).build()

    init {
        initFactory()
    }

    fun liveData() = liveDataModel

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    private fun initFactory() {
        disposable.add(RxPagedListBuilder(topGamesSourceFactory, pagedListConfig)
            .buildObservable()
            .subscribe {
                liveDataModel.postValue(it)
            })
    }

    private fun saveDataFromDb(list: List<GameData>) {
        getFromDBUseCase.saveGames(list)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(saveDataDbObserver())
    }

    private fun saveDataDbObserver(): CompletableObserver {
        return object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {
                Log.e("saveDataDbObserver", "Subscribe succes")
            }

            override fun onComplete() {
                Log.e("saveDataDbObserver", "Insert succes")
            }

            override fun onError(e: Throwable) {
                Log.e("saveDataDbObserver", e.toString())
            }

        }
    }


}