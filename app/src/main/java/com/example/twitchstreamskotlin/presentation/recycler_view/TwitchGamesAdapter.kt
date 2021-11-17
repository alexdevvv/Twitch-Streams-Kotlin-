package com.example.twitchstreamskotlin.presentation.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.model.GameData

class TwitchGamesAdapter: RecyclerView.Adapter<GameViewHolder>() {

    var list: List<GameData> = ArrayList<GameData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.game_item_view, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.setView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(gameDataModelList: List<GameData>) {
        list = gameDataModelList
        notifyDataSetChanged()
    }

}