package com.example.twitchstreamskotlin.model

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.data.room.GameDataEntity


class GameData(
    val id: Int,
    val name: String,
    val viewers: Int,
    val channels: Int,
    val logo: String
) {
    constructor(gameDataEntity: GameDataEntity): this(
        id = gameDataEntity.id,
        name = gameDataEntity.name,
        viewers = gameDataEntity.viewers,
        channels = gameDataEntity.channels,
        logo = gameDataEntity.logo

    )

    constructor(gameDataModel: GameDataModel): this(
        id = gameDataModel.id,
        name = gameDataModel.name,
        viewers = gameDataModel.viewers,
        channels = gameDataModel.channels,
        logo = gameDataModel.logo
    )
}