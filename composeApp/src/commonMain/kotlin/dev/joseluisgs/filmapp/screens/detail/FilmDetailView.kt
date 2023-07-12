package dev.joseluisgs.filmapp.screens.detail

import androidx.compose.runtime.Composable
import dev.joseluisgs.filmapp.screens.shared.FilmDetail

@Composable
fun DetailView(onClose: () -> Unit) {
    FilmDetail(onClose = onClose)
}