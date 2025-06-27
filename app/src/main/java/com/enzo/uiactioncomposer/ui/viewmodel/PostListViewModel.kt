package com.enzo.uiactioncomposer.ui.viewmodel

import com.enzo.uiactioncomposer.data.model.Post
import com.enzo.uiactioncomposer.domain.repository.PostRepository
import com.enzo.uiactioncomposer.ui.action.PostActionHandler
import com.enzo.uiactioncomposer.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PostListViewModel(
    override val postRepository: PostRepository
) : BaseViewModel(), PostActionHandler {

    override val viewModel: BaseViewModel = this

    private val _posts = MutableStateFlow(getMockPosts())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    // 特殊的點讚處理
    override suspend fun handleLikeClick(post: Post) {
        println("顯示點讚動畫")
        super.handleLikeClick(post) // 執行原始邏輯
    }

    private fun getMockPosts() = listOf(
        Post("3", "貼文列表頁", "專門內容", "作者C", 5, false),
        Post("4", "另一篇貼文", "更多內容", "作者D", 15, false)
    )
}