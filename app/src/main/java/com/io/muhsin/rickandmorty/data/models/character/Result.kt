package com.io.muhsin.rickandmorty.data.models.character

import com.io.muhsin.rickandmorty.data.models.character.Location
import com.io.muhsin.rickandmorty.data.models.character.Origin

data class Result(
    var created: String? = null,
    var episode: List<String?>? = null,
    var gender: String? = null,
    var id: Int? = null,
    var image: String? = null,
    var location: Location? = null,
    var name: String? = null,
    var origin: Origin? = null,
    var species: String? = null,
    var status: String? = null,
    var type: String? = null,
    var url: String? = null
)