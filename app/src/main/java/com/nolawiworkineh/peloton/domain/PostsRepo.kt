package com.nolawiworkineh.peloton.domain

import com.nolawiworkineh.peloton.data.network.HaleyPostsModel

interface PostsRepo {
    suspend fun getPosts(): List<HaleyPostsModel>
}