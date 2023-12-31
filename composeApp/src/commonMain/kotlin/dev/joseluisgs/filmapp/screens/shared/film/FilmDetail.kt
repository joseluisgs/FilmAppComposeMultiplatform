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
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.model.Film
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun FilmDetail(
    filmDetail: FilmViewModel.FilmDetails,
    onBackClick: () -> Unit,
    onFavoriteClick: (Film) -> Unit
) {
    // Recuerda que el box es un contenedor y el primero que se pinta
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Ponemos in texto en la parte superior derecha
        // Imagen
        DetailImage(filmDetail.film)
        // Icono de cerrar
        DetailCloseButton(
            onBackClick = onBackClick,
            modifier = Modifier.align(Alignment.TopEnd),

            )
        // Card
        DetailsInfo(
            film = filmDetail.film,
            isFavorite = filmDetail.isFavorite,
            onFavoriteClick = onFavoriteClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}

@Composable
private fun DetailsInfo(
    film: Film,
    isFavorite: Boolean,
    onFavoriteClick: (Film) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth().fillMaxHeight(0.6f)
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
                    onClick = { onFavoriteClick(film) },
                    modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp)
                        .pointerHoverIcon(PointerIcon.Hand)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(128.dp),
                        // color naranja
                        tint = if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary
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

@Composable
private fun DetailCloseButton(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Button(
        onClick = { onBackClick() },
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
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
