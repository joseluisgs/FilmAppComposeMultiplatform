package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.Res
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovedadesView() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        MovieCard(onClick = { /*TODO*/ })
    }
}


@Composable
fun MovieCard(onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            MovieImage()
            MovieInfo()
        }

    }
}

@Composable
fun MovieInfo() {
    Column(
        // Separados 16dp
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
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
}

@Composable
fun MovieImage() {
    val painter = painterResource(Res.image.demo)

    Column {
        Image(
            painter = painter,
            contentDescription = "Movie Image",
            modifier = Modifier.height(128.dp)
                .clip(RoundedCornerShape(5.dp))

        )
    }
}
