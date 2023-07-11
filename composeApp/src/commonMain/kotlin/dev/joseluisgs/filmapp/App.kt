package dev.joseluisgs.filmapp

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.tab.*
import dev.joseluisgs.filmapp.screens.favoritos.FavoritosTab
import dev.joseluisgs.filmapp.screens.home.NovedadesTab
import dev.joseluisgs.filmapp.screens.info.InfoTab
import dev.joseluisgs.filmapp.theme.AppTheme
import org.lighthousegames.logging.logging

private val logger = logging()

@OptIn(ExperimentalMaterial3Api::class, ExperimentalVoyagerApi::class)
@Composable
fun App() = AppTheme {
    val tabList = remember { listOf(NovedadesTab, FavoritosTab, InfoTab) }
    logger.info { "Iniciando la App: ${Res.string.app_name}" }
    // Inicializamos el navegador con la lista de tabs
    TabNavigator(
        NovedadesTab,
        tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = tabList
            )
        }
    ) { tabNavigator ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = tabNavigator.current.options.title,
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            },
            content = {
                // Obtenemos el contenido de la tab actual
                CurrentTab()
            },
            bottomBar = {
                // Creamos la barra de navegación
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ) {
                    tabList.forEach { tab ->
                        TabNavigationItem(tab)
                    }
                }
            }
        )
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = {
            Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title,
                tint = if (tabNavigator.current.key == tab.key) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.medium)
                },
            )
        },
        alwaysShowLabel = true,
        label = {
            Text(
                text = tab.options.title,
                color = if (tabNavigator.current.key == tab.key) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.medium)
                },
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
            )
        }
    )
}

