package com.enzo.uiactioncomposer.ui.action

import androidx.lifecycle.viewModelScope
import com.enzo.uiactioncomposer.data.model.News
import com.enzo.uiactioncomposer.domain.repository.NewsRepository
import com.enzo.uiactioncomposer.ui.base.BaseViewModel
import kotlinx.coroutines.launch

interface NewsActionHandler {
    val viewModel: BaseViewModel
    val newsRepository: NewsRepository

    fun handleNewsAction(action: NewsAction) = viewModel.viewModelScope.launch {
        try {
            viewModel.setLoading(true)
            when (action) {
                is NewsAction.Clicked -> handleNewsClick(action.news)
                is NewsAction.BookmarkClicked -> handleBookmarkClick(action.news)
                is NewsAction.ShareClicked -> handleNewsShareClick(action.news)
            }
        } catch (e: Exception) {
            println("錯誤: ${e.message}")
        } finally {
            viewModel.setLoading(false)
        }
    }

    suspend fun handleNewsClick(news: News) {
        viewModel.navigate("news_detail/${news.id}")
    }

    suspend fun handleBookmarkClick(news: News) {
        val result = if (news.isBookmarked) {
            newsRepository.unbookmarkNews(news.id)
        } else {
            newsRepository.bookmarkNews(news.id)
        }

        result.onSuccess {
            val message = if (news.isBookmarked) "已取消收藏" else "已收藏"
            viewModel.showSnackbar(message)
        }
    }

    suspend fun handleNewsShareClick(news: News) {
        viewModel.showSnackbar("已分享新聞")
    }
}
