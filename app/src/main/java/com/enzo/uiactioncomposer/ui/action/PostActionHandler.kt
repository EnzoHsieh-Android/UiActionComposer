package com.enzo.uiactioncomposer.ui.action

import androidx.lifecycle.viewModelScope
import com.enzo.uiactioncomposer.data.model.Post
import com.enzo.uiactioncomposer.domain.repository.PostRepository
import com.enzo.uiactioncomposer.ui.base.BaseViewModel
import kotlinx.coroutines.launch

interface PostActionHandler {
    val viewModel: BaseViewModel
    val postRepository: PostRepository

    // 主處理函數 - 使用默認實現
    fun handlePostAction(action: PostAction) = viewModel.viewModelScope.launch {
        try {
            viewModel.setLoading(true)
            when (action) {
                is PostAction.Clicked -> handlePostClick(action.post)
                is PostAction.LikeClicked -> handleLikeClick(action.post)
                is PostAction.ShareClicked -> handleShareClick(action.post)
            }
        } catch (e: Exception) {
            println("錯誤: ${e.message}")
        } finally {
            viewModel.setLoading(false)
        }
    }

    // 可覆寫的具體處理函數
    suspend fun handlePostClick(post: Post) {
        viewModel.navigate("post_detail/${post.id}")
    }

    suspend fun handleLikeClick(post: Post) {
        val result = if (post.isLiked) {
            postRepository.unlikePost(post.id)
        } else {
            postRepository.likePost(post.id)
        }

        result.onSuccess {
            val message = if (post.isLiked) "已取消點讚" else "已點讚"
            viewModel.showSnackbar(message)
        }
    }

    suspend fun handleShareClick(post: Post) {
        viewModel.showSnackbar("已分享貼文")
    }
}