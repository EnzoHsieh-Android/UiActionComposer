package com.enzo.uiactioncomposer.ui.viewmodel

import com.enzo.uiactioncomposer.data.model.News
import com.enzo.uiactioncomposer.data.model.Post
import com.enzo.uiactioncomposer.domain.repository.NewsRepository
import com.enzo.uiactioncomposer.domain.repository.PostRepository
import com.enzo.uiactioncomposer.ui.action.NewsActionHandler
import com.enzo.uiactioncomposer.ui.action.PostActionHandler
import com.enzo.uiactioncomposer.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    override val postRepository: PostRepository,
    override val newsRepository: NewsRepository
) : BaseViewModel(), PostActionHandler, NewsActionHandler {

    override val viewModel: BaseViewModel = this

    private val _posts = MutableStateFlow(getMockPosts())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _news = MutableStateFlow(getMockNews())
    val news: StateFlow<List<News>> = _news.asStateFlow()

    // 可以覆寫特定行為
    override suspend fun handleShareClick(post: Post) {
        // 主頁特殊的分享邏輯
        println("主頁分享追蹤")
        super.handleShareClick(post) // 調用原始邏輯
    }

    private fun getMockPosts() = listOf(
        Post("1", "第一篇貼文", "這是內容", "作者A", 10, false),
        Post("2", "第二篇貼文", "這是內容", "作者B", 25, true)
    )

    private fun getMockNews() = listOf(
        News("1", "科技新聞", "摘要內容", "科技日報", false),
        News("2", "生活新聞", "摘要內容", "生活週刊", true)
    )
}
