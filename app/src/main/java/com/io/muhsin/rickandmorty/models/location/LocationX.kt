package com.io.muhsin.rickandmorty.models.location

data class LocationX(
    var info: InfoX? = InfoX(),
    var results: List<ResultX>? = listOf()
)