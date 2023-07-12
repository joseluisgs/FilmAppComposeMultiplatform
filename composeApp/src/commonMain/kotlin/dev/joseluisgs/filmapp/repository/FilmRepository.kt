package dev.joseluisgs.filmapp.repository

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import dev.joseluisgs.filmapp.api.FilmRest
import dev.joseluisgs.filmapp.dto.FilmDto
import dev.joseluisgs.filmapp.error.FilmError
import dev.joseluisgs.filmapp.mapper.toFilm
import dev.joseluisgs.filmapp.model.Film
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.lighthousegames.logging.logging

private val logger = logging()

class FilmRepository(private val filmRest: FilmRest) {
    init {
        logger.info { "Init FilmRepository" }
    }


    suspend fun getRemoteFilms(): Result<List<Film>, FilmError> {
        logger.debug { "getFilms from remote" }

        val res = filmRest.client.get(
            "https://raw.githubusercontent.com/joseluisgs/FilmAppCompose/main/api/peliculas.json"
        )
        return if (res.status.value >= 400) {
            logger.error { "Error en el cliente" }
            Err(FilmError.NetworkProblem("Error ${res.status.value} al obtener las películas"))
        } else {
            // Como lo traigo de un json propio del GitHub
            // hago este truco
            val films = res.bodyAsText()
            val json = Json { ignoreUnknownKeys = true }
            Ok(json.decodeFromString<List<FilmDto>>(films).map {
                it.toFilm()
            })
        }
    }
}
