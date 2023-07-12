package dev.joseluisgs.filmapp.api

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class FilmRest {
    val client = HttpClient {
        // Configuración
        install(ContentNegotiation) {
            // Configuramos el cliente para que trabaje con JSON
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}
