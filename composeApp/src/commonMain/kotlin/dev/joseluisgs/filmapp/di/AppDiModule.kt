package dev.joseluisgs.filmapp.di

import dev.joseluisgs.filmapp.api.FilmRest
import dev.joseluisgs.filmapp.repository.FilmRepository
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::FilmRest)
    singleOf(::FilmRepository)
    singleOf(::FilmViewModel)
}

// Para la base de datos específica por plataforma
expect val databaseModule: org.koin.core.module.Module