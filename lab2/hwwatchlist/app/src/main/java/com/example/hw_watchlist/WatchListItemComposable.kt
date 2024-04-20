package com.example.hw

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color

@Composable
fun WatchListItemComposable(
    watchListItem: WatchListItem,
    onToggleWatchedStatus: (Boolean) -> Unit,
    onRemoveItem: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = if (watchListItem.checked) Color.LightGray else Color.Transparent
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Checkbox(
                checked = watchListItem.checked,
                onCheckedChange = { isChecked -> onToggleWatchedStatus(isChecked) },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = watchListItem.title,
                modifier = Modifier.weight(3f)
            )

            IconButton(onClick = onRemoveItem) {
                Icon(Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}
