package dev.joseluisgs.filmapp.screens.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.model.Film
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.lighthousegames.logging.logging

val logger = logging()

@Composable
fun MovieCard(film: Film, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            FilmImage(film)
            FilmInfo(film)
        }

    }
}

@Composable
fun FilmInfo(film: Film) {
    Column(
        // Separados 16dp
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
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
}

@Composable
fun FilmImage(film: Film) {
    val painter = asyncPainterResource(data = film.image)

    KamelImage(
        resource = painter,
        contentDescription = film.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10.dp)),
        onLoading = { progress -> CircularProgressIndicator(progress) },
        onFailure = { exception ->
            logger.error { "Error al cargar la imagen: ${exception.message}" }
        },
        //animationSpec = tween(),
    )
}