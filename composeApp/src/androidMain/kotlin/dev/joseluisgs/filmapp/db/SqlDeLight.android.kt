package dev.joseluisgs.filmapp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dev.joseluisgs.filmapp.AndroidApp

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        // Hemos cogido el contexto de la aplicación
        return AndroidSqliteDriver(AppDatabase.Schema, AndroidApp.getAppContext(), "films.db")
    }
}