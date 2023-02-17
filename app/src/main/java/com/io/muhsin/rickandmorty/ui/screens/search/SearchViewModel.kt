package com.io.muhsin.rickandmorty.ui.screens.search

import androidx.lifecycle.ViewModel
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
}