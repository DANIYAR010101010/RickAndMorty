package com.io.muhsin.rickandmorty.ui.screens.person

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.rickandmorty.data.models.character.Result
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _allMovies = MutableLiveData<List<Result?>>()
    val allMovies: LiveData<List<Result?>>
        get() = _allMovies

    fun getAllCharacters() {
        viewModelScope.launch {
            repository.getAllCharacters().let {
                if (it.isSuccessful){
                    _allMovies.postValue(it.body()?.results ?: emptyList())
                } else{
                    Log.e("check data","failed to load movies: ${it.errorBody()}")
                }
            }
        }
    }

}