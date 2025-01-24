package com.nolawiworkineh.peloton.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nolawiworkineh.peloton.data.network.HaleyPostsModel
import com.nolawiworkineh.peloton.domain.PostsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BhavikaViewModel @Inject constructor(
    private val postsRepo: PostsRepo
): ViewModel(){

    var state by mutableStateOf<List<HaleyPostsModel>>(emptyList())

    fun getPosts(){
        viewModelScope.launch {
            state = postsRepo.getPosts()
            Log.e("list", state.toString())
        }
    }
}