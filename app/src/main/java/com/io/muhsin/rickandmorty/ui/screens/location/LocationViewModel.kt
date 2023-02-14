package com.io.muhsin.rickandmorty.ui.screens.location

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.rickandmorty.data.models.location.ResultX
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _location = MutableLiveData<List<ResultX?>>()
    val location: LiveData<List<ResultX?>>
        get() = _location

    fun getLocation() {
        viewModelScope.launch {
            repository.getLocation().let {
                if (it.isSuccessful){
                    _location.postValue(it.body()?.results ?: emptyList())
                } else{
                    Log.e("check data","failed to load locations: ${it.errorBody()}")
                }
            }
        }
    }

}