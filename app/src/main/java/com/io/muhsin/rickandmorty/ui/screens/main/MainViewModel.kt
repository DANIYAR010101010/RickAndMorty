package com.io.muhsin.rickandmorty.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.room.util.query
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import com.io.muhsin.rickandmorty.data.network.ApiService
import com.io.muhsin.rickandmorty.models.character.Character
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.models.search.SearchResponse
import com.io.muhsin.rickandmorty.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {


}