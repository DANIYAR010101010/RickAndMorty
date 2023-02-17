package com.io.muhsin.rickandmorty.ui.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.query
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import com.io.muhsin.rickandmorty.models.character.Character
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

}