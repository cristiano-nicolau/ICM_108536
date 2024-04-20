package com.example.hw

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WatchListItem (
    val id: Int,
    val title: String,
    watched: Boolean = false
) {
    var checked: Boolean by mutableStateOf(watched)
}