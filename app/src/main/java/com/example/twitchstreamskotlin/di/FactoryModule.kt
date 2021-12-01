package com.example.twitchstreamskotlin.di

import com.example.twitchstreamskotlin.presentation.recycler_view.TopGamesSourceFactory
import org.koin.dsl.module

val factoryModule = module {
    single {
        TopGamesSourceFactory(get())
    }
}