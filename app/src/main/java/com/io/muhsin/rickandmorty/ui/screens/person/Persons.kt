package com.io.muhsin.rickandmorty.ui.screens.person

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
import com.io.muhsin.rickandmorty.ui.items.CharacterItem
import com.io.muhsin.rickandmorty.MainViewModel


@Composable
fun Persons() {
    val viewModel = hiltViewModel<MainViewModel>()
    val navController = NavController
    val allCharacters = viewModel.persons.collectAsState().value.collectAsLazyPagingItems()
    Surface(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.padding(20.dp)) {
            items(items = allCharacters, key = { it.id.toString() }) { item ->
                if (item != null) {
                    CharacterItem(item = item, navController = navController)
                }
            }
        }
    }
}