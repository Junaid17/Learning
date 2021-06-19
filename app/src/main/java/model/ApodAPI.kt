package model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodAPI {

    @GET("/planetary/apod?")
    fun getApod(@Query("api_key") api_key : String): Single<Apod>
}