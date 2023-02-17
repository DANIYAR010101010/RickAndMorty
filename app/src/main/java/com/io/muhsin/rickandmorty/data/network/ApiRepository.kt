package com.io.muhsin.rickandmorty.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceCharacters
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceEpisodes
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceLocation
import javax.inject.Inject

class ApiRepository@Inject constructor(private val apiService: ApiService) {

    fun getAllCharacters() = Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceCharacters(apiService)
        }
    ).flow

     fun getLocation()= Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceLocation(apiService)
        }
    ).flow

    fun getEpisode()=  Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceEpisodes(apiService)
        }
    ).flow




}