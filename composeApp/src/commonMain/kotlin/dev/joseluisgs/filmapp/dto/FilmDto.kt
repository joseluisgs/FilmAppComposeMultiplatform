package dev.joseluisgs.filmapp.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("director")
    val director: String,
    @SerialName("synopsis")
    val synopsis: String,
    @SerialName("image")
    val image: String,
    @SerialName("rate")
    val rate: String,
)