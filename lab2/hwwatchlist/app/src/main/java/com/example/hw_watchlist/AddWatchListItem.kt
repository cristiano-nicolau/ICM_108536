package com.example.hw

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddWatchListItem(onAddItem: (WatchListItem) -> Unit) {
    var title by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Enter the movie you want to watch") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        onAddItem(WatchListItem(id = System.currentTimeMillis().toInt(), title = title))
                        title = ""
                    }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text("Add")
            }
        }
    }
}

