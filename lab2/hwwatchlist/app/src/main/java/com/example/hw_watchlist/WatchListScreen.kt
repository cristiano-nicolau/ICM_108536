package com.example.hw

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    watchListViewModel: WatchListViewModel = viewModel()
) {
    val watchList = watchListViewModel.watchList

    Column(modifier = modifier) {

        Text(
            text = "Watch List",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp),
        )

        AddWatchListItem(onAddItem = { watchListViewModel.addWatchListItem(it) })

        LazyColumn {
            items(watchList) { item ->
                WatchListItemComposable(
                    watchListItem = item,
                    onToggleWatchedStatus = { watchListViewModel.changeWatched(item, it) },
                    onRemoveItem = { watchListViewModel.remove(item) }
                )
            }

        }
    }
}
