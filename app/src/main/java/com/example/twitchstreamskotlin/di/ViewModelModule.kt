package com.example.twitchstreamskotlin.di

import com.example.twitchstreamskotlin.presentation.MainActivityVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainActivityVM>()
}