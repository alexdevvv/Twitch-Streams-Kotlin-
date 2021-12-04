package com.example.twitchstreamskotlin.di

import com.example.twitchstreamskotlin.presentation.recycler_view.pagination.GamesFromDbFactory
import com.example.twitchstreamskotlin.presentation.recycler_view.pagination.TopGamesSourceFactory
import org.koin.dsl.module

val factoryModule = module {
    single {
        TopGamesSourceFactory(get(), get())
    }

    single {
        GamesFromDbFactory(get())
    }
}