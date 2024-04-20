package com.example.hw

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WatchListViewModel : ViewModel() {
    private val _watchList = getWatchList().toMutableStateList()
    val watchList: List<WatchListItem>
        get() = _watchList

    fun remove(item: WatchListItem) {
        _watchList.remove(item)
    }

    fun changeWatched(item: WatchListItem, watched: Boolean) =
        watchList.find { it.id == item.id }?.let { watchListItem ->
            watchListItem.checked = watched
        }


    fun addWatchListItem(item: WatchListItem) {
        _watchList.add(item)
    }

}

private fun getWatchList() : List<WatchListItem> {
    return listOf(
        WatchListItem(1, "Fast & Furious 9"),
        WatchListItem(2, "Hangover 3"),
        WatchListItem(3, "The Godfather"),
        WatchListItem(4, "The Dark Knight"),
        WatchListItem(5, "Oppenheimer"),
        WatchListItem(6, "The Matrix"),
        WatchListItem(7, "Kung Fu Panda"),
        WatchListItem(8, "Godzilla vs. Kong"),
        WatchListItem(9, "The Lion King"),
        WatchListItem(10, "The Avengers"),
    )
}