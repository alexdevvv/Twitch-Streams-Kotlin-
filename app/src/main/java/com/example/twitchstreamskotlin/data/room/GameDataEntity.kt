package com.example.twitchstreamskotlin.data.room

import android.widget.VideoView
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class GameDataEntity(@PrimaryKey val id: Int,
                     val name: String,
                     val viewers: Int,
                     val channels: Int,
                     val logo: String) {


}