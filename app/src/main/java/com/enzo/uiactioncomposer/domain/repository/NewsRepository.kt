package com.enzo.uiactioncomposer.domain.repository

interface NewsRepository {
    suspend fun bookmarkNews(newsId: String): Result<Unit>
    suspend fun unbookmarkNews(newsId: String): Result<Unit>
}