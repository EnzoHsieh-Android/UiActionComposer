package com.enzo.uiactioncomposer.ui.action

import com.enzo.uiactioncomposer.data.model.News

sealed interface NewsAction {
    data class Clicked(val news: News) : NewsAction
    data class BookmarkClicked(val news: News) : NewsAction
    data class ShareClicked(val news: News) : NewsAction
}