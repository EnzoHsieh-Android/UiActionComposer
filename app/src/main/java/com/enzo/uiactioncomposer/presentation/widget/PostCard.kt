package com.enzo.uiactioncomposer.presentation.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.enzo.uiactioncomposer.data.model.Post
import com.enzo.uiactioncomposer.ui.action.PostAction

@Composable
fun PostCard(
    post: Post,
    onAction: (PostAction) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onAction(PostAction.Clicked(post)) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = post.content,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "作者: ${post.authorName}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                IconButton(
                    onClick = { onAction(PostAction.LikeClicked(post)) }
                ) {
                    Icon(
                        imageVector = if (post.isLiked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "點讚",
                        tint = if (post.isLiked) Color.Red else Color.Gray
                    )
                }

                Text(
                    text = post.likeCount.toString(),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(
                    onClick = { onAction(PostAction.ShareClicked(post)) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "分享"
                    )
                }
            }
        }
    }
}