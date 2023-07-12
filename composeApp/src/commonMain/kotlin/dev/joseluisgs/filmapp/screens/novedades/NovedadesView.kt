package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovedadesView() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Novedades",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}