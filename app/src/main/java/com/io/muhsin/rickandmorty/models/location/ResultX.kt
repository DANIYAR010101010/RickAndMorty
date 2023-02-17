package com.io.muhsin.rickandmorty.models.location

data class ResultX(
    var created: String? = null,
    var dimension: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var residents: List<String?>? = null,
    var type: String? = null,
    var url: String? = null
)