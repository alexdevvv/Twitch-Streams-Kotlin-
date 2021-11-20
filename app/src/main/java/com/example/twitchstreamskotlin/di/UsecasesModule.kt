package com.example.twitchstreamskotlin.di

import com.example.twitchstreamskotlin.data.DataRepositoryImpl
import com.example.twitchstreamskotlin.domain.GetFromDBUseCase
import com.example.twitchstreamskotlin.domain.GetFromServerUseCase
import com.example.twitchstreamskotlin.domain.repository.DataRepository
import org.koin.dsl.module

val useCasesModule  = module {
    single {
        GetFromServerUseCase(get())
    }

    single {
        GetFromDBUseCase(get())
    }

    single<DataRepository> {
        DataRepositoryImpl(get(), get())
    }
}