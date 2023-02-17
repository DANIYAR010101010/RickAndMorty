package com.io.muhsin.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.io.muhsin.rickandmorty.ui.navigation.NavHost
import com.io.muhsin.rickandmorty.ui.screens.main.MainViewModel
import com.io.muhsin.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                val viewModel = hiltViewModel<ActivityViewModel>()
                val navController = rememberNavController()
                NavHost(navController = navController, viewModel = viewModel)
            }
        }
    }
}

