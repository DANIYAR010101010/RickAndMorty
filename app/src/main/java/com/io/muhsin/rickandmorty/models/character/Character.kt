package com.io.muhsin.rickandmorty.models.character

data class Character(
    var info: Info? = null,
    var results: List<Result>? = null
)