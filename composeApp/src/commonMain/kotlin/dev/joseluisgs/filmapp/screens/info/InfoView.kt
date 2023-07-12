package dev.joseluisgs.filmapp.screens.info

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.ExternalLink
import compose.icons.feathericons.Github
import dev.joseluisgs.filmapp.Res
import dev.joseluisgs.filmapp.utils.getPlatformName
import dev.joseluisgs.filmapp.utils.openUrl
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoView() {
    InfoContent()
}

@Composable
fun InfoContent() {
    // Hacemos un card con el contenido
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Card
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(16.dp).fillMaxWidth(0.5f)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                // Icono de la App
                InfoIcon()
                // Texto de la App
                InfoText()
            }

        }


    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InfoIcon() {
    val painter = painterResource(Res.image.jlgs)
    val openDialog = remember { mutableStateOf(false) }
    IconButton(
        onClick = {
            openDialog.value = true
        },
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
            .pointerHoverIcon(PointerIcon.Hand)
    ) {
        Image(
            painter = painter,
            contentDescription = "App Icon",
        )
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Alerta") },
            text = { Text(text = "Este soy yo, y ya has visto como funciona una alerta") },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text(text = "Aceptar")
                }
            })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InfoText() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 16.dp).fillMaxWidth()
    ) {
        Text(
            text = Res.string.app_name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight
        )
        Text(
            text = getPlatformName(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = MaterialTheme.typography.titleMedium.fontWeight
        )
        Text(
            text = "Versión: ${Res.string.app_version}",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = Res.string.app_author,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    openUrl(Res.string.app_author_web)
                }
            ) {
                Icon(
                    imageVector = FeatherIcons.ExternalLink,
                    contentDescription = "Website",
                    modifier = Modifier.size(16.dp).pointerHoverIcon(PointerIcon.Hand)
                )
            }
            IconButton(
                onClick = {
                    openUrl(Res.string.app_author_github)
                }
            ) {
                Icon(
                    imageVector = FeatherIcons.Github,
                    contentDescription = "Github",
                    modifier = Modifier.size(16.dp).pointerHoverIcon(PointerIcon.Hand)
                )
            }
        }
    }
}



