package com.io.muhsin.rickandmorty.ui.tablayout

import androidx.compose.runtime.Composable
import com.io.muhsin.rickandmorty.ui.screens.episode.Episodes
import com.io.muhsin.rickandmorty.ui.screens.location.Locations
import com.io.muhsin.rickandmorty.ui.screens.person.Persons

typealias ComposableFun = @Composable ()-> Unit
sealed class TabItem(
    val title:String,
    val screens:ComposableFun
) {

    object Persons:TabItem(title = "Person", screens = {  Persons() })
    object Locations:TabItem(title = "Location", screens = { Locations() })
    object Episodes:TabItem(title = "Episode", screens = { Episodes() })
}