package com.enzo.uiactioncomposer.data.model

data class Post(
    val id: String,
    val title: String,
    val content: String,
    val authorName: String,
    val likeCount: Int,
    val isLiked: Boolean
)