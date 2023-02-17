package com.io.muhsin.rickandmorty.ui.screens.episode

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.io.muhsin.rickandmorty.ui.characterItem.LocationItem
import com.io.muhsin.rickandmorty.ui.items.EpisodeItem
import com.io.muhsin.rickandmorty.ui.screens.location.LocationViewModel


@Composable
fun Episodes() {
    val viewModel = hiltViewModel<EpisodeViewModel>()
    val navController = NavController
    val allEpisodes = viewModel.getEpisodes().collectAsLazyPagingItems()
    viewModel.getEpisodes()
    Surface(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.padding(20.dp)) {
            items(items = allEpisodes, key = { it.id.toString() }) { item ->
                if (item != null) {
                    EpisodeItem(item = item, navController = navController)
                }
            }
        }
    }
}