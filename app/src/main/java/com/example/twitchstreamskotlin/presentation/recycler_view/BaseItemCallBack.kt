package com.example.twitchstreamskotlin.presentation.recycler_view

import androidx.recyclerview.widget.DiffUtil
import com.example.twitchstreamskotlin.model.GameData

class BaseItemCallBack: DiffUtil.ItemCallback<GameData>() {
    override fun areItemsTheSame(oldItem: GameData, newItem: GameData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GameData, newItem: GameData): Boolean {
        return oldItem.name == newItem.name && oldItem.channels == newItem.channels
    }
}