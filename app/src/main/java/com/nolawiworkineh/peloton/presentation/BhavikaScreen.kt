package com.nolawiworkineh.peloton.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlin.reflect.KProperty


@Composable
fun BhavikaScreen(
    viewModel: BhavikaViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(state){ post ->
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Text(
                    text = post.title,
                    color = Color.Black
                )
            }

        }

    }

}
