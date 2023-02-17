package com.io.muhsin.rickandmorty.ui.screens.person


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    fun getAllCharacters() : Flow<PagingData<Result>> = repository.getAllCharacters().cachedIn(viewModelScope)

}