package com.io.muhsin.rickandmorty.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import com.io.muhsin.rickandmorty.models.episode.ResultZ
import com.io.muhsin.rickandmorty.models.location.ResultX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _persons = repository.getAllCharacters("").cachedIn(viewModelScope)
    private val _episodes = repository.getEpisode("").cachedIn(viewModelScope)
    private val _locations = repository.getLocation("").cachedIn(viewModelScope)
    var persons = MutableStateFlow(_persons)
    var episodes = MutableStateFlow(_episodes)
    var locations = MutableStateFlow(_locations)


    fun searchCharacters(name: String = "") {
        persons.value = repository.getAllCharacters(name)
        episodes.value = repository.getEpisode(name)
        locations.value = repository.getLocation(name)
    }

}