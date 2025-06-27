package com.enzo.uiactioncomposer.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.enzo.uiactioncomposer.presentation.widget.NewsCard
import com.enzo.uiactioncomposer.presentation.widget.PostCard
import com.enzo.uiactioncomposer.ui.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = koinViewModel()
    val posts by viewModel.posts.collectAsState()
    val news by viewModel.news.collectAsState()

    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = "貼文",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(posts) { post ->
            PostCard(
                post = post,
                onAction = viewModel::handlePostAction
            )
        }

        item {
            Text(
                text = "新聞",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(news) { newsItem ->
            NewsCard(
                news = newsItem,
                onAction = viewModel::handleNewsAction
            )
        }
    }
}