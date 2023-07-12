package dev.joseluisgs.filmapp.model

data class Film(
    val id: Int,
    val name: String,
    val director: String,
    val synopsis: String,
    val image: String,
    val rate: String,
)