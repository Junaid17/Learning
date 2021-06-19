package com.example.learning.di

import dagger.Component
import model.ApodService
import viewmodel.ApodViewModel

@Component(modules = [APIModule::class])
interface APIComponent {
    fun inject(apodService: ApodService)
    fun inject(viewModel: ApodViewModel)
}