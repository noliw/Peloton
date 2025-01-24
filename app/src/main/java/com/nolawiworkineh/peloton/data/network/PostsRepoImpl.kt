package com.nolawiworkineh.peloton.data.network

import android.util.Log
import com.nolawiworkineh.peloton.domain.PostsRepo
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class PostsRepoImpl @Inject constructor(
    private val apiService: HaleyApiService
): PostsRepo{
    override suspend fun getPosts(): List<HaleyPostsModel> {
        return try {
            Log.e("PostsCall", "Mada Api call successfully.")
            apiService.getPosts()

        } catch (e: Exception) {
            when (e){
                is CancellationException -> throw e
                else -> Log.e("PostsRepoImplError", "The following error occured ${e.message}")
            }
            emptyList()
        }
    }
}