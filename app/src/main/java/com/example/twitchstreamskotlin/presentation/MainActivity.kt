package com.example.twitchstreamskotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.data.retrofit.TwitchResponseMain
import com.example.twitchstreamskotlin.data.retrofit.TwitchStreamAPI
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api: TwitchStreamAPI = getRetrofit().create(TwitchStreamAPI::class.java)
        api.getTwitchStream()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(twitchResponseObserver())

    }

    fun getRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder().baseUrl("https://api.twitch.tv/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    fun twitchResponseObserver(): SingleObserver<TwitchResponseMain> {
        return object: SingleObserver<TwitchResponseMain> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(t: TwitchResponseMain) {
                Log.i("XXX", t.top?.size.toString())
            }

            override fun onError(e: Throwable) {

            }

        }
    }
}