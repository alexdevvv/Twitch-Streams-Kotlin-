package com.example.twitchstreamskotlin.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityVM(val useCaseGetFromServer: GetFromServerUseCase, val getFromDBUseCase: GetFromDBUseCase) : ViewModel() {
    private var liveDataModel: MutableLiveData<List<GameData>> = MutableLiveData()

    init {
        getDataFromServer()
    }

    fun liveData() = liveDataModel

    private fun getDataFromServer() {
        useCaseGetFromServer.fetchGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(twitchResponseObserver())
    }

    private fun getDataFromDb() {
        getFromDBUseCase.getGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(dbResponseObserver())
    }

    private fun saveDataFromDb(list: List<GameData>) {
        getFromDBUseCase.saveGames(list)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(saveDataDbObserver())
    }

    private fun twitchResponseObserver(): SingleObserver<List<GameData>> {
        return object : SingleObserver<List<GameData>> {
            override fun onSubscribe(d: Disposable) {
                Log.i("twitchResponseObserver", "подписан")
            }

            override fun onSuccess(t: List<GameData>) {
                Log.e("twitchResponseObserver", "получение данных")
                liveDataModel.postValue(t)
                saveDataFromDb(t)

                Log.e("twitchResponseObserver", t.size.toString() + " длинна записанного листа")

            }

            override fun onError(e: Throwable) {
                Log.e("twitchResponseObserver", "ошибка " + e.printStackTrace().toString())
                getDataFromDb()

            }
        }
    }

    private fun saveDataDbObserver(): CompletableObserver {
        return object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {
                Log.e("saveDataDbObserver",  "Subscribe succes")
            }

            override fun onComplete() {
                Log.e("saveDataDbObserver",  "Insert succes")
            }

            override fun onError(e: Throwable) {
                Log.e("saveDataDbObserver",  e.toString())
            }

        }
    }

    private fun dbResponseObserver(): SingleObserver<List<GameData>>{
        return object : SingleObserver<List<GameData>> {
            override fun onSubscribe(d: Disposable) {
                Log.i("DB", "DB подписана")
            }

            override fun onSuccess(t: List<GameData>) {
                Log.i("DB", "DB читает данные")
                Log.i("Длинна списка ", t.size.toString())
                liveDataModel.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.e("DB", "DB ошибка " + e.printStackTrace().toString())

            }
        }
    }

}