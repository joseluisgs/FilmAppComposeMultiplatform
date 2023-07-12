package dev.joseluisgs.filmapp.screens.detail

import androidx.compose.runtime.Composable
import dev.joseluisgs.filmapp.screens.shared.MovieDetail

@Composable
fun DetailView(onClose: () -> Unit) {
    MovieDetail(onClose = onClose)
}