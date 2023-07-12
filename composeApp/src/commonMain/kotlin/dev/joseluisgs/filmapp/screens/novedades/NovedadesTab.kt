package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Film
import dev.joseluisgs.filmapp.Res
import dev.joseluisgs.filmapp.screens.detail.DetailView
import dev.joseluisgs.filmapp.screens.shared.ViewType
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.lighthousegames.logging.logging

private val logger = logging()

object NovedadesTab : Tab, KoinComponent {

    init {
        logger.debug { "Inicializando NovedadesTab" }
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = Res.string.tab_novedades
            val icon = rememberVectorPainter(FeatherIcons.Film)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val viewModel: FilmViewModel by inject()
        var screen by remember { mutableStateOf(ViewType.NOVEDADES) }

        if (screen == ViewType.NOVEDADES) {
            NovedadesView(
                vm = rememberScreenModel { viewModel }
            ) {
                logger.debug { "Click en Detalle" }
                screen = ViewType.DETALLE
            }
        } else {
            DetailView(
                vm = rememberScreenModel { viewModel },
                onBackClick = {
                    logger.debug { "Click en Cerrar" }
                    screen = ViewType.NOVEDADES
                })
        }
    }
}
