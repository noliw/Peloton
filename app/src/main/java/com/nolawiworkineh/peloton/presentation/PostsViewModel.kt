package com.nolawiworkineh.peloton.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nolawiworkineh.peloton.data.network.PostModel
import com.nolawiworkineh.peloton.domain.PostsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Body
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repo: PostsRepo
) : ViewModel() {

    var state by mutableStateOf<List<PostModel>>(emptyList())

    var message by mutableStateOf<String?>(null)


    fun getPost() {
        viewModelScope.launch {
            try {
                state = repo.getPosts()
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> throw e
                    else -> Log.e(
                        "PostsViewModel",
                        "The following error occurred when fetching data ${e.message}"
                    )
                }
            }

        }
    }

    fun sendPost(post: PostModel) {
        viewModelScope.launch {
            try {
                val result = repo.sendPost(post)
                message = result?.title ?: "Post failed"
            } catch (e: Exception) {
                message = "An error occurred"
            }
        }
    }


}