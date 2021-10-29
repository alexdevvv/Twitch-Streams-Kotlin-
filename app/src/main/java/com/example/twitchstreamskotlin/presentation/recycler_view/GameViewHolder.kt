package com.example.twitchstreamskotlin.presentation.recycler_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.squareup.picasso.Picasso

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     lateinit var imageViewLogo: ImageView
     lateinit var textViewGameName: TextView
     lateinit var textViewNumberChannels: TextView
     lateinit var textViewNumberViewers: TextView

    init {
        imageViewLogo = itemView.findViewById(R.id.game_logo_iv)
        textViewGameName = itemView.findViewById(R.id.game_name_tv)
        textViewNumberChannels = itemView.findViewById(R.id.number_channels_tv)
        textViewNumberViewers = itemView.findViewById(R.id.number_viewers_tv)
    }

    fun setView(gameDataModel: GameDataModel) {
        textViewGameName.setText("Game name: ${gameDataModel.name}")
        textViewNumberViewers.setText("Viewers: ${gameDataModel.viewers}")
        textViewNumberChannels.setText("Channels: ${gameDataModel.channels}")
        Picasso.with(itemView.context)
            .load(gameDataModel.logo)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageViewLogo)

    }


}