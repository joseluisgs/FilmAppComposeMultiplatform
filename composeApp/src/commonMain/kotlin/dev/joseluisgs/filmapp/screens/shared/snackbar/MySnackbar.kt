package dev.joseluisgs.filmapp.screens.shared.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun MySnackbar(
    message: String,
    actionLabel: String = "",
    duration: SnackbarDuration = SnackbarDuration.Short,
    onDismiss: () -> Unit = {},
    onAction: () -> Unit = {},
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(snackbarHostState) {
        when (snackbarHostState.showSnackbar(message, actionLabel, duration = duration)) {
            SnackbarResult.Dismissed -> onDismiss()
            SnackbarResult.ActionPerformed -> onAction()
        }
    }

    SnackbarHost(hostState = snackbarHostState)
}
