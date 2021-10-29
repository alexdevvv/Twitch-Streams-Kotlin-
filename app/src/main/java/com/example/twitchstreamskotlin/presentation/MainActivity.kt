package com.example.twitchstreamskotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.UpdateView
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.data.retrofit.Top
import com.example.twitchstreamskotlin.data.retrofit.TwitchResponseMain
import com.example.twitchstreamskotlin.data.retrofit.TwitchStreamAPI
import com.example.twitchstreamskotlin.presentation.recycler_view.TwitchGamesAdapter
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity(), UpdateView {

    lateinit var twitchGamesAdapter: TwitchGamesAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        twitchGamesAdapter = TwitchGamesAdapter(this)
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = twitchGamesAdapter

        val api: TwitchStreamAPI = getRetrofit().create(TwitchStreamAPI::class.java)
        api.getTwitchStream()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(twitchResponseObserver())
    }

    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://api.twitch.tv/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    fun twitchResponseObserver(): SingleObserver<TwitchResponseMain> {
        return object : SingleObserver<TwitchResponseMain> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(t: TwitchResponseMain) {
                val top: List<Top>? = t.top
                var gameDataModelList: List<GameDataModel>? = parseDataFromServer(top!!)
                updateView(gameDataModelList!!)
                Log.i("YYY", TwitchGamesAdapter.list.size.toString())

            }

            override fun onError(e: Throwable) {

            }
        }
    }

    fun parseDataFromServer(list: List<Top>): List<GameDataModel>? {
        val listGameData: MutableList<GameDataModel> = ArrayList<GameDataModel>()
        for (top in list) {
            listGameData.add(GameDataModel.Companion.getGameDataModelFromTop(top))
        }
        return listGameData
    }

    override fun updateView(gameDataModelsList: List<GameDataModel>) {
        twitchGamesAdapter.setData(gameDataModelsList)
    }
}