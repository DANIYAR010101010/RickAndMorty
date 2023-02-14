package com.io.muhsin.rickandmorty.data.models.episode

data class Result(
    var air_date: String? = null,
    var characters: List<String?>? = null,
    var created: String? = null,
    var episode: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var url: String? = null
)