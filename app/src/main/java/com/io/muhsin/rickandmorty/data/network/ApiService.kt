package com.io.muhsin.rickandmorty.data.network


import com.io.muhsin.rickandmorty.models.character.Character
import com.io.muhsin.rickandmorty.models.character.Info
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.models.episode.Episode
import com.io.muhsin.rickandmorty.models.location.LocationX
import com.io.muhsin.rickandmorty.models.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getAllCharacter(
        @Query("page") page: Int,
        @Query("name") name: String,
    ): Response<Character>

    @GET("location")
    suspend fun getLocation(
        @Query("page") page: Int,
        @Query("name") name: String,
    ): Response<LocationX>

    @GET("episode")
    suspend fun getEpisode(
        @Query("page") page: Int,
        @Query("name") name: String,
    ): Response<Episode>
}