package dev.joseluisgs.filmapp.screens.shared.film

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.model.Film
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun FilmDetail(film: Film, onBackClick: () -> Unit) {
    // Recuerda que el box es un contenedor y el primero que se pinta
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Ponemos in texto en la parte superior derecha
        // Imagen
        DetailImage(film)
        // Icono de cerrar
        DetailCloseButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onBackClick = onBackClick
        )
        // Card
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f)
                .align(Alignment.BottomCenter)
                .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
        ) {
            // Lo voy a hacer con un columna
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                // Una fila que tiene el titulo y el director y el icono de favorito
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    // Columna con el titulo y el director
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = film.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.W600,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = film.director,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.W600,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = film.rate,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                    // Icono de favorito
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp)
                            .pointerHoverIcon(PointerIcon.Hand)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(128.dp)
                        )
                    }
                }
                // Sinopsis
                Text(
                    text = film.synopsis,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }

    }
}

@Composable
private fun DetailCloseButton(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    IconButton(
        onClick = { onBackClick() },
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand),
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            modifier = Modifier.padding(8.dp),
            tint = Color.Blue
        )
    }
}

@Composable
private fun DetailImage(film: Film) {
    val painter = asyncPainterResource(data = film.image)
    KamelImage(
        resource = painter,
        contentDescription = film.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth(),
        animationSpec = tween()
        /*onLoading = { progress -> CircularProgressIndicator(progress) },
        onFailure = { exception ->
            logger.error { "Error al cargar la imagen: ${exception.message}" }
        },*/
    )

}
