package com.example.twitchstreamskotlin.di

import com.example.twitchstreamskotlin.data.retrofit.TwitchStreamAPI
import io.reactivex.Single
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { Retrofit.Builder().baseUrl("https://api.twitch.tv/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build() }

    single { get<Retrofit>().create(TwitchStreamAPI::class.java) }
}