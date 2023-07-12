package dev.joseluisgs.filmapp.screens.shared

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable


@Composable
fun FilmList(onItemClick: () -> Unit) {
    // hacemos una lazy list de 5
    LazyColumn {
        items(5) {
            MovieCard(onClick = onItemClick)
        }
    }

}
