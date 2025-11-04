package com.nolawiworkineh.peloton.data.network

import android.util.Log
import com.nolawiworkineh.peloton.domain.PostsRepo
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val apiService: ApiService
): PostsRepo{
    override suspend fun getPosts(): List<PostModel> {
        return try {
            apiService.getPosts()
        } catch (e: Exception){
            when (e){
                is CancellationException -> throw e
                else -> Log.e("RepoImpl", "The following error occurred when fetching data ${e.message}")
            }
            emptyList()
        }
    }

    override suspend fun sendPost(post: PostModel): PostModel? {
        return try {
            apiService.sendPosts(post)
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> throw e
                else -> Log.e("RepoImpl", "Error posting data: ${e.message}")
            }
            null
        }
    }
}