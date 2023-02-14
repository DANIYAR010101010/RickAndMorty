package com.io.muhsin.rickandmorty

import androidx.lifecycle.ViewModel
import com.io.muhsin.rickandmorty.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

}