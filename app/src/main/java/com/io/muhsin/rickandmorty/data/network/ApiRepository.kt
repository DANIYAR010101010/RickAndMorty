package com.io.muhsin.rickandmorty.data.network

import javax.inject.Inject

class ApiRepository@Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCharacters()= apiService.getAllCharacter()

    suspend fun getLocation()= apiService.getLocation()

    suspend fun getEpisode()= apiService.getEpisode()


}