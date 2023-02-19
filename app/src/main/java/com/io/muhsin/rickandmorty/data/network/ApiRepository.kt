package com.io.muhsin.rickandmorty.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceCharacters
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceEpisodes
import com.io.muhsin.rickandmorty.data.network.pagingsource.PagingSourceLocation
import javax.inject.Inject

class ApiRepository@Inject constructor(private val apiService: ApiService) {

    fun getAllCharacters(name: String) = Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceCharacters(apiService,name)
        }
    ).flow

     fun getLocation(name: String)= Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceLocation(apiService,name)
        }
    ).flow

    fun getEpisode(name: String)=  Pager(
        config = PagingConfig(
            pageSize = 5,
        ),
        pagingSourceFactory = {
            PagingSourceEpisodes(apiService,name)
        }
    ).flow




}