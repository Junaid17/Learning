package com.example.learning.di

import dagger.Module
import dagger.Provides
import model.ApodAPI
import model.ApodService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class APIModule {
    private val BASE_URL="https://api.nasa.gov"

    @Provides
    fun provideCountriesAPI() :ApodAPI{
        return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApodAPI::class.java)

    }


    @Provides
    fun provideCountriesService():ApodService{
        return ApodService()
    }
}