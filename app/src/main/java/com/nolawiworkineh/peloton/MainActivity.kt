package com.nolawiworkineh.peloton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nolawiworkineh.peloton.presentation.PostsScreen
import com.nolawiworkineh.peloton.ui.theme.PelotonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PelotonTheme {
                PostsScreen()
            }
        }
    }
}

