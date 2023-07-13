package dev.joseluisgs.filmapp.di

import dev.joseluisgs.filmapp.db.DataBase
import dev.joseluisgs.filmapp.db.DriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

// Modulo de dependencias de la base de datos de la plataforma
actual val databaseModule = module {
    singleOf(::DriverFactory)
    singleOf(::DataBase)
}