package com.nolawiworkineh.peloton.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HaleyRetrofitClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}