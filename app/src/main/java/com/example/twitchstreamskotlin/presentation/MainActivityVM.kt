package com.example.twitchstreamskotlin.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityVM(val useCaseGetFromServer: GetFromServerUseCase) : ViewModel() {
    private var liveData: MutableLiveData<List<GameDataModel>> = MutableLiveData()

    init {
        getDataFromServer()
    }

    fun liveData() = liveData

    private fun getDataFromServer() {
        useCaseGetFromServer.getGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(twitchResponseObserver())
    }

    private fun twitchResponseObserver(): SingleObserver<List<GameDataModel>> {
        return object : SingleObserver<List<GameDataModel>> {
            override fun onSubscribe(d: Disposable) {
                Log.i("XXX", "подписан")
            }

            override fun onSuccess(t: List<GameDataModel>) {
                liveData.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.e("XXX", e.printStackTrace().toString())
            }
        }
    }


}