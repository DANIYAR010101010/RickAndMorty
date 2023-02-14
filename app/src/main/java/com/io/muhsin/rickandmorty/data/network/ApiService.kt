package com.io.muhsin.rickandmorty.data.network

import androidx.annotation.IntRange
import com.io.muhsin.rickandmorty.data.models.character.Character
import com.io.muhsin.rickandmorty.data.models.episode.Episode
import com.io.muhsin.rickandmorty.data.models.location.LocationX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacter(
        @Query("q")query :String? = null,
        @Query("pages")@IntRange(from =  1) page :Int = 1,
        @Query("count")@IntRange(from =  1,to = Long.MAX_VALUE) pageSize :Int = DEFAULT_BUFFER_SIZE
    ): Response<Character>

    @GET("location")
    suspend fun getLocation(): Response<LocationX>
    @GET("episode")
    suspend fun getEpisode(): Response<Episode>
}