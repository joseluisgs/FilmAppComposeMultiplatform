package dev.joseluisgs.filmapp.db

import app.cash.sqldelight.db.SqlDriver
import db.AppDatabaseQueries


expect class DriverFactory {
    fun createDriver(): SqlDriver
}

class DataBase(private val driverFactory: DriverFactory) {
    private val driver = driverFactory.createDriver()
    private val appDatabase = AppDatabase(driver)
    val queries: AppDatabaseQueries = appDatabase.appDatabaseQueries
}

