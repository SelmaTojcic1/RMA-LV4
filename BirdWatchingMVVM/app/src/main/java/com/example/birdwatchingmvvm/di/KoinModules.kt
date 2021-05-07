package com.example.birdwatchingmvvm.di

import com.example.birdwatchingmvvm.model.BirdCounter
import com.example.birdwatchingmvvm.ui.viewmodels.BirdCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<BirdCounter> { BirdCounter() }
}

val viewModelModule = module {
    viewModel<BirdCounterViewModel> { BirdCounterViewModel(get()) }
}