package com.nolawiworkineh.peloton.domain

import com.nolawiworkineh.peloton.data.network.PostModel
import retrofit2.http.POST

interface PostsRepo {
    suspend fun getPosts(): List<PostModel>
    suspend fun sendPost(post: PostModel): PostModel?
}