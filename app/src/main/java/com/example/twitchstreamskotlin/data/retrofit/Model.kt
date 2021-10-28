package com.example.twitchstreamskotlin.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TwitchResponseMain {
    var total = 0
    var top: List<Top>? = null

    override fun toString(): String {
        return "TwitchResponseMain{" +
                "Total=" + total +
                ", top=" + top +
                '}'
    }
}

class API {
    var accept = "application/vnd.twitchtv.v5+json"
    var client_id = "ahuoi1tl0qmqbyi8jo8nitbmuaad7w"
}

class Box {
    var large: String? = null
    var medium: String? = null
    var small: String? = null
    var template: String? = null
}

class Game {
    var name: String? = null
    var id = 0
    var giantbombId = 0
    var box: Box? = null
    var logo: Logo? = null
    var localizedName: String? = null
    var locale: String? = null
}

class GameDataModel(val name: String, val viewers: Int, val channels: Int, val logo: String) {

    companion object {
        fun getGameDataModelFromTop(top: Top): GameDataModel {
            val name: String = top.game!!.name!!
            val viewers: Int = top.viewers
            val channels: Int = top.channels
            val logo: String = top.game?.logo?.medium!!
            return GameDataModel(name, viewers, channels, logo)
        }
    }
}

class Logo {
    var large: String? = null
    var medium: String? = null
    var small: String? = null
    var template: String? = null
}

class Top {
    var game: Game? = null
    var viewers = 0
    var channels = 0
}



