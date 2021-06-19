package model

import com.example.learning.di.DaggerAPIComponent
import io.reactivex.Single
import javax.inject.Inject

class ApodService {

    @Inject
    lateinit var api:ApodAPI

    init {
    DaggerAPIComponent.create().inject(this)
    }

    fun getApod():Single<Apod>{
        return api.getApod()
    }
}