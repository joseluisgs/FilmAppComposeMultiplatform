package dev.joseluisgs.filmapp.screens.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.joseluisgs.filmapp.Res


@Composable
fun MovieCard(onClick: () -> Unit) {
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
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Movie Author",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.W600,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "10/10",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.W400,
            color = MaterialTheme.colorScheme.secondary
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
