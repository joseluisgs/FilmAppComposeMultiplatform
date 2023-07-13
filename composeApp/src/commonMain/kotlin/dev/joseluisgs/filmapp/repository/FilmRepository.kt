package dev.joseluisgs.filmapp.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import dev.joseluisgs.filmapp.api.FilmRest
import dev.joseluisgs.filmapp.db.DataBase
import dev.joseluisgs.filmapp.dto.FilmDto
import dev.joseluisgs.filmapp.error.FilmError
import dev.joseluisgs.filmapp.mapper.toFilm
import dev.joseluisgs.filmapp.mapper.toFilmEntity
import dev.joseluisgs.filmapp.model.Film
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.lighthousegames.logging.logging

private val logger = logging()

class FilmRepository(private val filmRest: FilmRest, private val filmDb: DataBase) {
    init {
        logger.info { "Init FilmRepository" }
    }


    suspend fun getRemoteFilms(): Result<Flow<List<Film>>, FilmError> = withContext(Dispatchers.IO) {
        logger.debug { "getFilms from remote" }
        try {
            val res = filmRest.client.get(
                "https://raw.githubusercontent.com/joseluisgs/FilmAppCompose/main/api/peliculas.json"
            )
            return@withContext if (res.status.value >= 400) {
                logger.error { "Error en el cliente" }
                Err(FilmError.NetworkProblem("Error ${res.status.value} al obtener las películas"))
            } else {
                // Como lo traigo de un json propio del GitHub
                // hago este truco
                val films = res.bodyAsText()
                val json = Json { ignoreUnknownKeys = true }
                Ok(
                    flowOf(
                        json.decodeFromString<List<FilmDto>>(films)
                            .map { it.toFilm() }
                    )
                )
            }
        } catch (e: Exception) {
            logger.error { "Error al obtener las películas: ${e.message}" }
            return@withContext Err(FilmError.NetworkProblem("Error al obtener las películas: ${e.message}"))
        }
    }


    suspend fun getFavoriteFilms(): Flow<List<Film>> = withContext(Dispatchers.IO) {
        logger.debug { "getFilms from local" }
        return@withContext filmDb.queries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list ->
                list.map { it.toFilm() }
            }
    }

    suspend fun getFavoriteFilmById(id: Long): Film? = withContext(Dispatchers.IO) {
        logger.debug { "getFilmById from local" }
        return@withContext filmDb.queries.selectById(id).executeAsOneOrNull()?.toFilm()
    }

    suspend fun existsFavoriteFilmById(id: Long): Boolean = withContext(Dispatchers.IO) {
        logger.debug { "existsFilmById from local" }
        return@withContext filmDb.queries.selectById(id).executeAsOneOrNull() != null
    }

    suspend fun insertFavoriteFilm(film: Film) = withContext(Dispatchers.IO) {
        logger.debug { "insertFilm from local" }
        return@withContext filmDb.queries.insertFull(film.toFilmEntity())
    }

    suspend fun deleteFavoriteFilm(film: Film) = withContext(Dispatchers.IO) {
        logger.debug { "deleteFilm from local" }
        return@withContext filmDb.queries.deleteById(film.id)
    }
}
