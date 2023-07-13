package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.model.Film
import dev.joseluisgs.filmapp.screens.shared.film.FilmList
import dev.joseluisgs.filmapp.screens.shared.snackbar.MySnackbar
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovedadesView(vm: FilmViewModel, onItemClick: (film: Film) -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Column(Modifier.weight(1f)) {
            if (vm.stateFilms.isLoading) {
                logger.debug { "Cargando las películas" }
                LoadingDataIndicator()
            } else {
                logger.debug { "Peliculas cargadas" }
                FilmList(films = vm.stateFilms.remoteFilms, onItemClick = onItemClick)
            }
        }
        if (vm.stateFilms.isError) {
            logger.error { "Error cargando las películas" }
            MySnackbar(
                message = vm.stateFilms.errorMessage,
                actionLabel = "Reintentar",
                onAction = {
                    coroutineScope.launch {
                        vm.loadRemoteFilms()
                    }
                }
            )
        }
    }
}

@Composable
fun LoadingDataIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .defaultMinSize(minWidth = 96.dp, minHeight = 96.dp)
        )
    }
}
