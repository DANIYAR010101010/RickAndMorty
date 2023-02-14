package com.io.muhsin.rickandmorty.data.models.location

data class LocationX(
    var info: InfoX? = InfoX(),
    var results: List<ResultX>? = listOf()
)