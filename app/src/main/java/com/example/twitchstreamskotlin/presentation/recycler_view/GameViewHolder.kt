package com.example.twitchstreamskotlin.presentation.recycler_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.data.retrofit.GameDataModel
import com.example.twitchstreamskotlin.databinding.GameItemViewBinding
import com.squareup.picasso.Picasso

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: GameItemViewBinding by viewBinding()

    fun setView(gameDataModel: GameDataModel) {
        with(binding) {
            gameNameTv.text = ("Game name: ${gameDataModel.name}")
            numberViewersTv.text = ("Viewers: ${gameDataModel.viewers}")
            numberChannelsTv.text = ("Channels: ${gameDataModel.channels}")
            Picasso.with(itemView.context)
                .load(gameDataModel.logo)
                .placeholder(R.drawable.ic_launcher_background)
                .into(gameLogoIv)
        }

    }

}