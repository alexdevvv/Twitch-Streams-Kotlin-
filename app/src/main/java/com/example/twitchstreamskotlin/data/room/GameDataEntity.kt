package com.example.twitchstreamskotlin.data.room

import android.widget.VideoView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.twitchstreamskotlin.model.GameData

@Entity
class GameDataEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val viewers: Int,
    val channels: Int,
    val logo: String
) {
    constructor(gameData: GameData): this(
        id = gameData.id,
        name = gameData.name,
        viewers = gameData.viewers,
        channels = gameData.channels,
        logo = gameData.logo

    )
}