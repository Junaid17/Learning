package model

import io.reactivex.Single
import retrofit2.http.GET

interface ApodAPI {

    @GET("/planetary/apod?api_key=TwBS3vlBDbKZ6mDk62hKW2fwzc37bXZ055TgCu7k")
    fun getApod(): Single<Apod>
}