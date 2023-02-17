package com.io.muhsin.rickandmorty.ui.screens.location

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.io.muhsin.rickandmorty.models.location.ResultX
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    fun getLocations() : Flow<PagingData<ResultX>> = repository.getLocation().cachedIn(viewModelScope)

}