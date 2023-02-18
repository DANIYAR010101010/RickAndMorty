package com.io.muhsin.rickandmorty.models.search

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.io.muhsin.rickandmorty.models.character.Info
import com.io.muhsin.rickandmorty.models.character.Result
import java.io.Serializable

@Entity(tableName = "result")
data class SearchResponse(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null
):Serializable
