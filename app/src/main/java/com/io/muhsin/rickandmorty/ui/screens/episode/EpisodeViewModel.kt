package com.io.muhsin.rickandmorty.ui.screens.episode


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import com.io.muhsin.rickandmorty.models.episode.ResultZ
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    fun getEpisodes() : Flow<PagingData<ResultZ>> = repository.getEpisode().cachedIn(viewModelScope)

}