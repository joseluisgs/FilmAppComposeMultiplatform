package dev.joseluisgs.filmapp.mapper

import db.FilmEntity
import dev.joseluisgs.filmapp.dto.FilmDto
import dev.joseluisgs.filmapp.model.Film

fun FilmDto.toFilm() = Film(
    id = this.id,
    name = this.name,
    director = this.director,
    synopsis = this.synopsis,
    image = this.image,
    rate = this.rate,
)

fun FilmEntity.toFilm() = Film(
    id = this.id,
    name = this.name,
    director = this.director,
    synopsis = this.synopsis,
    image = this.image,
    rate = this.rate,
)

fun Film.toFilmEntity() = FilmEntity(
    id = this.id,
    name = this.name,
    director = this.director,
    synopsis = this.synopsis,
    image = this.image,
    rate = this.rate,
)
