package dev.joseluisgs.filmapp.screens.detail

import androidx.compose.runtime.Composable
import dev.joseluisgs.filmapp.model.Film
import dev.joseluisgs.filmapp.screens.shared.film.FilmDetail
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel

@Composable
fun DetailView(vm: FilmViewModel, onBackClick: () -> Unit, onFavoriteClick: (Film) -> Unit) {
    FilmDetail(filmDetail = vm.selectedRemoteFilm, onBackClick = onBackClick, onFavoriteClick = onFavoriteClick)
}