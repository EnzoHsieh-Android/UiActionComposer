package com.enzo.uiactioncomposer.data.repository

import com.enzo.uiactioncomposer.domain.repository.PostRepository
import kotlinx.coroutines.delay

class PostRepositoryImpl : PostRepository {
    override suspend fun likePost(postId: String): Result<Unit> {
        delay(500) // 模擬網路請求
        return Result.success(Unit)
    }

    override suspend fun unlikePost(postId: String): Result<Unit> {
        delay(500)
        return Result.success(Unit)
    }
}
