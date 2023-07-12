package dev.joseluisgs.filmapp.screens.favoritos

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.Res
import org.lighthousegames.logging.logging


private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritosView() {
    // Recuerda que el box es un contenedor y el primero que se pinta
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Ponemos in texto en la parte superior derecha
        // Imagen
        val painter = painterResource(Res.image.demo)
        Image(
            painter = painter,
            contentDescription = "Movie Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        // Icono de cerrar
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.TopEnd).pointerHoverIcon(PointerIcon.Hand)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                modifier = Modifier.padding(8.dp)
            )
        }
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
                            text = "Movie Title",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.W600,
                        )
                        Text(
                            text = "Movie Author",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.W600
                        )
                        Text(
                            text = "10/10",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.W400
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
                    text = "Movie Description lajsalk js klasj aksj aksj aksj aksj aksj aklsj aksja skjaskj askljaslkja skj askjaksjaskja kjsa kaj sk kjaskja js akj askj aksj akj akjs aksj akj sas asoasoias iaso aos oa soais aosi oasi aois aosi",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }

    }
}
