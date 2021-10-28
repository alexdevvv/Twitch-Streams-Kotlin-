package com.example.twitchstreamskotlin.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitKeeper private constructor(){
    companion object {
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl("https://api.twitch.tv/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }

}