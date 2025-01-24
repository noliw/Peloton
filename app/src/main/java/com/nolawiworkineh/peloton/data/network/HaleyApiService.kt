package com.nolawiworkineh.peloton.data.network

import retrofit2.http.GET

interface HaleyApiService {

    @GET("posts")
    suspend fun getPosts(): List<HaleyPostsModel>
}