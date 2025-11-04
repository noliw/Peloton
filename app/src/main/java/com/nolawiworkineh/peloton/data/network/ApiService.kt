package com.nolawiworkineh.peloton.data.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostModel>

    @POST("posts")
    suspend fun sendPosts(@Body post: PostModel): PostModel

}