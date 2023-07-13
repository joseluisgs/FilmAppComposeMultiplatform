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
    var state by mutableStateOf(State())
        private set

    var selectedRemoteFilm by mutableStateOf(Film())
        private set

    init {
        logger.info { "Inicializando FilmViewModel" }
        state = state.copy(isLoading = true)
        // Primero cargamos los datos remotos
        coroutineScope.launch {
            while (true) {
                loadRemoteFilms()
                delay(REFRESH_INTERVAL)
            }
        }
        // Nos conectamos y cargamos los datos locales de favoritos
        coroutineScope.launch {
            loadFavoriteFilms()
        }
    }

    private suspend fun loadFavoriteFilms() {
        logger.debug { "Cargando películas favoritas" }
        repository.getFavoriteFilms()
            .collect {
                logger.debug { "Películas favoritas cargadas" }
                state = state.copy(favoriteFilms = it)
            }
    }

    suspend fun loadRemoteFilms() {
        logger.debug { "Cargando películas remotas" }
        repository.getRemoteFilms().mapBoth(
            success = {
                logger.debug { "Películas remotas cargadas" }
                state = state.copy(isLoading = false, remoteFilms = it.first())
            },
            failure = {
                logger.error { "Error al cargar las películas remotas" }
                state = state.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message
                )
            }
        )
    }

    fun setRemoteFilmDetails(film: Film) {
        selectedRemoteFilm = film
    }


    // El estado de la vista
    data class State(
        val isLoading: Boolean = false,
        val remoteFilms: List<Film> = emptyList(),
        val favoriteFilms: List<Film> = emptyList(),
        val isError: Boolean = false,
        val errorMessage: String = ""
    )
}