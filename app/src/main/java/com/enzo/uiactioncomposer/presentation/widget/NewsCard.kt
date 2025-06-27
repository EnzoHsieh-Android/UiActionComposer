package com.enzo.uiactioncomposer.presentation.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.enzo.uiactioncomposer.data.model.News
import com.enzo.uiactioncomposer.ui.action.NewsAction

@Composable
fun NewsCard(
    news: News,
    onAction: (NewsAction) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onAction(NewsAction.Clicked(news)) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = news.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = news.summary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "來源: ${news.source}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                IconButton(
                    onClick = { onAction(NewsAction.BookmarkClicked(news)) }
                ) {
                    Icon(
                        imageVector = if (news.isBookmarked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "收藏",
                        tint = if (news.isBookmarked) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                }

                IconButton(
                    onClick = { onAction(NewsAction.ShareClicked(news)) }
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