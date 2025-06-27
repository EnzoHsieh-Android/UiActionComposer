package com.enzo.uiactioncomposer.domain.repository

interface PostRepository {
    suspend fun likePost(postId: String): Result<Unit>
    suspend fun unlikePost(postId: String): Result<Unit>
}