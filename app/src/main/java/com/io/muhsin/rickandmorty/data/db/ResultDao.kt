package com.io.muhsin.rickandmorty.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.io.muhsin.rickandmorty.models.character.Result
import com.io.muhsin.rickandmorty.models.search.SearchResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {
    @Query("SELECT * FROM result")
    fun getAllResults():Flow<List<SearchResponse>>
}