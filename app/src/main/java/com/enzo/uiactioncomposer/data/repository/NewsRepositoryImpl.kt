package com.enzo.uiactioncomposer.data.repository

import com.enzo.uiactioncomposer.domain.repository.NewsRepository
import kotlinx.coroutines.delay

class NewsRepositoryImpl : NewsRepository {
    override suspend fun bookmarkNews(newsId: String): Result<Unit> {
        delay(500)
        return Result.success(Unit)
    }

    override suspend fun unbookmarkNews(newsId: String): Result<Unit> {
        delay(500)
        return Result.success(Unit)
    }
}