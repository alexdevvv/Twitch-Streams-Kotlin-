package com.example.twitchstreamskotlin.presentation.recycler_view

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel

class TwitchGamesAdapter(val activity: Activity) : RecyclerView.Adapter<GameViewHolder>() {

    companion object {
        var list: List<GameDataModel> = ArrayList<GameDataModel>()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.game_item_view, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        var gameDataModel: GameDataModel = list.get(position)
        holder.setView(gameDataModel)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(gameDataList: List<GameDataModel>) {
        list = gameDataList
        notifyDataSetChanged()

    }

}