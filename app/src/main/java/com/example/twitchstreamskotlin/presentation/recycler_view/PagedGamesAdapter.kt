package com.example.twitchstreamskotlin.presentation.recycler_view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.model.GameData

class PagedGamesAdapter(val activity: Activity): PagedListAdapter<GameData, GameViewHolder>(BaseItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.game_item_view, parent, false)
        return GameViewHolder(view, activity = activity)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setView(it)
        }
    }
}