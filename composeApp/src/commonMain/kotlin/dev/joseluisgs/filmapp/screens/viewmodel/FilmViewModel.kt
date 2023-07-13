package dev.joseluisgs.filmapp.screens.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.github.michaelbull.result.mapBoth
import dev.joseluisgs.filmapp.model.Film
import dev.joseluisgs.filmapp.repository.FilmRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

private val logger = logging()
private val REFRESH_INTERVAL = 1000L * 60L // 1 minute

class FilmViewModel(
    private val repository: FilmRepository
) : ScreenModel {
    var stateFilms by mutableStateOf(StateFilms())
        private set

    var selectedRemoteFilm by mutableStateOf(FilmDetails())
        private set

    init {
        logger.info { "Inicializando FilmViewModel" }
        stateFilms = stateFilms.copy(isLoading = true)
        // Nos conectamos y cargamos los datos locales de favoritos
        coroutineScope.launch {
            loadFavoriteFilms()
        }
        // Primero cargamos los datos remotos
        coroutineScope.launch {
            while (true) {
                loadRemoteFilms()
                delay(REFRESH_INTERVAL)
            }
        }

    }

    private suspend fun loadFavoriteFilms() {
        logger.debug { "Cargando películas favoritas" }
        repository.getFavoriteFilms()
            .collect {
                logger.debug { "Películas favoritas cargadas" }
                stateFilms = stateFilms.copy(favoriteFilms = it)
            }
    }

    suspend fun loadRemoteFilms() {
        logger.debug { "Cargando películas remotas" }
        repository.getRemoteFilms().mapBoth(
            success = {
                logger.debug { "Películas remotas cargadas" }
                stateFilms = stateFilms.copy(isLoading = false, remoteFilms = it.first())
            },
            failure = {
                logger.error { "Error al cargar las películas remotas" }
                stateFilms = stateFilms.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message
                )
            }
        )
    }

    fun setRemoteFilmDetails(film: Film) {
        logger.debug { "Cargando detalles de la película" }
        selectedRemoteFilm = selectedRemoteFilm.copy(film = film, isFavorite = stateFilms.favoriteFilms.contains(film))
    }

    fun setFavoriteFilm(film: Film) {
        // Si es favorito lo quitamos, si no lo añadimos
        if (stateFilms.favoriteFilms.contains(film)) {
            logger.debug { "Quitando película de favoritos" }
            coroutineScope.launch {
                // Esta comprobación es redundante, pero por si acaso la dejamos
                if (repository.existsFavoriteFilmById(film.id)) {
                    logger.debug { "Película existe en favoritos" }
                    repository.deleteFavoriteFilm(film)
                }
                selectedRemoteFilm = selectedRemoteFilm.copy(isFavorite = !selectedRemoteFilm.isFavorite)
            }
        } else {
            logger.debug { "Añadiendo película a favoritos" }
            coroutineScope.launch {
                if (!repository.existsFavoriteFilmById(film.id)) {
                    logger.debug { "Película no existe en favoritos" }
                    repository.insertFavoriteFilm(film)
                }
                selectedRemoteFilm = selectedRemoteFilm.copy(isFavorite = !selectedRemoteFilm.isFavorite)
            }
        }

    }


    // El estado de la vista
    data class StateFilms(
        val isLoading: Boolean = false,
        val remoteFilms: List<Film> = emptyList(),
        val favoriteFilms: List<Film> = emptyList(),
        val isError: Boolean = false,
        val errorMessage: String = ""
    )

    data class FilmDetails(
        val film: Film = Film(),
        val isFavorite: Boolean = false,
    )
}