package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.joseluisgs.filmapp.screens.shared.MovieList
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovedadesView(onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        MovieList(onItemClick = onItemClick)
    }
}

