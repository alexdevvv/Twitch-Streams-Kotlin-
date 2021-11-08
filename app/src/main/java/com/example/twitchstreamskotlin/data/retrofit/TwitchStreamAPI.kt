package com.example.twitchstreamskotlin.data.retrofit

import com.example.twitchstreamskotlin.domain.repository.DataRepository
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

private const val  accept = "application/vnd.twitchtv.v5+json"
private const val client_id = "ahuoi1tl0qmqbyi8jo8nitbmuaad7w"

interface TwitchStreamAPI {
    @Headers("Accept:$accept", "Client-ID:$client_id")
    @GET("kraken/games/top")
    fun getTwitchStream(): Single<TwitchResponseMain>
}