package dev.joseluisgs.filmapp.error

sealed class FilmError(val message: String) {
    class NetworkProblem(message: String) : FilmError(message)
    class NotFound(message: String) : FilmError(message)
}