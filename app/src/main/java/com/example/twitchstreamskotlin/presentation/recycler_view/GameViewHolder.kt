package com.example.twitchstreamskotlin.presentation.recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.databinding.GameItemViewBinding
import com.example.twitchstreamskotlin.model.GameData
import com.squareup.picasso.Picasso

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: GameItemViewBinding by viewBinding()

    fun setView(gameData: GameData) {
        with(binding) {
            gameNameTv.text = ("Game name: ${gameData.name}")
            numberViewersTv.text = ("Viewers: ${gameData.viewers}")
            numberChannelsTv.text = ("Channels: ${gameData.channels}")
            Picasso.with(itemView.context)
                .load(gameData.logo)
                .placeholder(R.drawable.ic_launcher_background)
                .into(gameLogoIv)
        }

    }

}