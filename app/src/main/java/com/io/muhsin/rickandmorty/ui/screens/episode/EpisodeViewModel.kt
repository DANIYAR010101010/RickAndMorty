package com.io.muhsin.rickandmorty.ui.screens.episode

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.rickandmorty.data.models.episode.Result
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _episode = MutableLiveData<List<Result?>>()
    val location: LiveData<List<Result?>>
        get() = _episode

    fun getEpisode() {
        viewModelScope.launch {
            repository.getEpisode().let {
                if (it.isSuccessful){
                    _episode.postValue(it.body()?.results ?: emptyList())
                } else{
                    Log.e("check data","failed to load locations: ${it.errorBody()}")
                }
            }
        }
    }

}