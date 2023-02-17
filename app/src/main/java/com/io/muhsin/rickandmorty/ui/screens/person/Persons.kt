package com.io.muhsin.rickandmorty.ui.screens.person

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.ui.items.CharacterItem


@Composable
fun Persons() {
    val viewModel = hiltViewModel<PersonViewModel>()
    val navController = NavController
    val allCharacters = viewModel.getAllCharacters().collectAsLazyPagingItems()
    viewModel.getAllCharacters()
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