package dev.joseluisgs.filmapp.model

data class Film(
    val id: Long = NEW_ID,
    val name: String = "",
    val director: String = "",
    val synopsis: String = "",
    val image: String = "",
    val rate: String = "",
) {
    companion object {
        val NEW_ID = 0L
    }
}