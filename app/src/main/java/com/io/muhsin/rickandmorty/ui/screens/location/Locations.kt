package com.io.muhsin.rickandmorty.ui.screens.location

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.io.muhsin.rickandmorty.ui.characterItem.LocationItem


@Composable
fun Locations() {
    val viewModel = hiltViewModel<LocationViewModel>()
    val navController = NavController
    val allLocations = viewModel.location.observeAsState(listOf()).value
    viewModel.getLocation()
    Surface(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.padding(20.dp)) {
                items(allLocations.take(10)) { item ->
                if (item != null) {
                    LocationItem(item = item, navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}