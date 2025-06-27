package com.enzo.uiactioncomposer.ui.action

import com.enzo.uiactioncomposer.data.model.Post

sealed interface PostAction {
    data class Clicked(val post: Post) : PostAction
    data class LikeClicked(val post: Post) : PostAction
    data class ShareClicked(val post: Post) : PostAction
}