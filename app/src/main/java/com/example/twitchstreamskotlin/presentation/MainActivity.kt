package com.example.twitchstreamskotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.databinding.ActivityMainBinding
import com.example.twitchstreamskotlin.presentation.recycler_view.TwitchGamesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val twitchGamesAdapter = TwitchGamesAdapter()
    private val viewModel: MainActivityVM by viewModel()
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        updateView()
    }

     private fun updateView() {
        viewModel.liveData().observe(this, {
            twitchGamesAdapter.setData(it)
        })
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = twitchGamesAdapter
        }

    }
}