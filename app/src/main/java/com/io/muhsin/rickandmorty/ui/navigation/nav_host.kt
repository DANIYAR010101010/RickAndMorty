package com.io.muhsin.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.io.muhsin.rickandmorty.ActivityViewModel
import com.io.muhsin.rickandmorty.ui.screens.episode.Episodes
import com.io.muhsin.rickandmorty.ui.screens.location.Locations
import com.io.muhsin.rickandmorty.ui.screens.main.MainScreen
import com.io.muhsin.rickandmorty.ui.screens.person.Persons
import com.io.muhsin.rickandmorty.ui.screens.search.Search

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object Persons : Screens("persons_screen")
    object Locations : Screens("location_screen")
    object Episodes : Screens("episodes_screen")
    object SearchScreen : Screens("search_screen")

}
@Composable
fun NavHost(navController: NavHostController,viewModel: ActivityViewModel) {

    androidx.navigation.compose.NavHost(navController = navController, startDestination = Screens.MainScreen.route ) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController= navController)
        }
        composable(Screens.Persons.route) {
            Persons()
        }
        composable(Screens.Locations.route) {
            Locations()
        }
        composable(Screens.Episodes.route) {
            Episodes()
        }
        composable(Screens.SearchScreen.route) {
           Search()
        }
    }
}