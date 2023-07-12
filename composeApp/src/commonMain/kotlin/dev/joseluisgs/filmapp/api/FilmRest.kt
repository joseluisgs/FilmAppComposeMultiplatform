package dev.joseluisgs.filmapp.api

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.jetbrains.skia.Image

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


object ImageDownloader {
    private val imageClient = HttpClient {
    }

    suspend fun downloadImage(url: String): ImageBitmap {
        val res = imageClient.get(url)
        return Image.makeFromEncoded(res.body()).toComposeImageBitmap()
    }
}
