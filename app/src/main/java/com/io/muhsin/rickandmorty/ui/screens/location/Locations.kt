package com.io.muhsin.rickandmorty.ui.screens.location

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.io.muhsin.rickandmorty.ui.characterItem.LocationItem
import com.io.muhsin.rickandmorty.ui.screens.main.MainViewModel


@Composable
fun Locations() {
    val viewModel = hiltViewModel<MainViewModel>()
    val navController = NavController
    val allLocations = viewModel.locations.collectAsState().value.collectAsLazyPagingItems()

    Surface(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.padding(20.dp)) {
                items(allLocations) { item ->
                if (item != null) {
                    LocationItem(item = item, navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}