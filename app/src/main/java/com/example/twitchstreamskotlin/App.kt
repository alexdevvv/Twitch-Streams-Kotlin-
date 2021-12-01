package com.example.twitchstreamskotlin

import android.app.Application
import com.example.twitchstreamskotlin.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(retrofitModule, viewModelModule, useCasesModule, roomModule, factoryModule))
        }
    }
}