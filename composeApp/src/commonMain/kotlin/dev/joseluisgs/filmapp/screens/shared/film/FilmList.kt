package dev.joseluisgs.filmapp.screens.shared.film

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.joseluisgs.filmapp.model.Film


@Composable
fun FilmList(films: List<Film>, onItemClick: (film: Film) -> Unit) {
    // hacemos una lazy list de 5
    LazyColumn {
        items(films) { film ->
            MovieCard(
                film = film,
                onClick = onItemClick
            )
        }
    }

}
