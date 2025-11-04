package com.nolawiworkineh.peloton.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nolawiworkineh.peloton.data.network.PostModel

@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val message = viewModel.message

    LaunchedEffect(Unit) {
        viewModel.getPost()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                viewModel.sendPost(
                    PostModel(
                        userId = 1,
                        title = "Interview Post",
                        body = "Hello from the eBay interview!"
                    )
                )
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "Send New Post"
            )
        }

        message?.let {
            Text(text = "Response: $it", modifier = Modifier.padding(bottom = 16.dp))
        }

        LazyColumn {
            items(state) { post ->
                Card(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = post.title, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

