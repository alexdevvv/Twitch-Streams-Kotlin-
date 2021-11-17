package com.example.twitchstreamskotlin

import com.example.twitchstreamskotlin.data.retrofit.GameDataModel

interface UpdateView {
    fun updateView(gameDataModelModelList: List<GameDataModel>)
}