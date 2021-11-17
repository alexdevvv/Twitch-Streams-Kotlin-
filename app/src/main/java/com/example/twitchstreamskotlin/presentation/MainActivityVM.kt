package com.example.twitchstreamskotlin.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.model.GameData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityVM(val useCaseGetFromServer: GetFromServerUseCase) : ViewModel() {
    private var liveDataModel: MutableLiveData<List<GameData>> = MutableLiveData()

    init {
        getDataFromServer()
    }

    fun liveData() = liveDataModel

    private fun getDataFromServer() {
        useCaseGetFromServer.getGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(twitchResponseObserver())
    }

    private fun twitchResponseObserver(): SingleObserver<List<GameData>> {
        return object : SingleObserver<List<GameData>> {
            override fun onSubscribe(d: Disposable) {
                Log.i("XXX", "подписан")
            }

            override fun onSuccess(t: List<GameData>) {
                liveDataModel.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.e("XXX", e.printStackTrace().toString())
            }
        }
    }

}