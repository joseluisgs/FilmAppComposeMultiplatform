package dev.joseluisgs.filmapp.screens.detail

import androidx.compose.runtime.Composable
import dev.joseluisgs.filmapp.screens.shared.FilmDetail
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel

@Composable
fun DetailView(vm: FilmViewModel, onBackClick: () -> Unit) {
    FilmDetail(onBackClick = onBackClick)
}