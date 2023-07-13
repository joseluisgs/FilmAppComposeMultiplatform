package dev.joseluisgs.filmapp.screens.favoritos

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Star
import dev.joseluisgs.filmapp.Res
import dev.joseluisgs.filmapp.screens.detail.DetailView
import dev.joseluisgs.filmapp.screens.shared.views.ViewType
import dev.joseluisgs.filmapp.screens.viewmodel.FilmViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.lighthousegames.logging.logging

private val logger = logging()

object FavoritosTab : Tab, KoinComponent {

    init {
        logger.debug { "Inicializando FavoritosTab" }
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = Res.string.tab_favoritos
            val icon = rememberVectorPainter(FeatherIcons.Star)

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
            FavoritosView(
                vm = rememberScreenModel { viewModel },
                onItemClick = {
                    viewModel.setRemoteFilmDetails(it)
                    logger.debug { "Click en Detalle con Film: $it" }
                    screen = ViewType.DETALLE
                }
            )

        } else {
            DetailView(
                vm = rememberScreenModel { viewModel },
                onBackClick = {
                    logger.debug { "Click en Cerrar" }
                    screen = ViewType.NOVEDADES
                },
                onFavoriteClick = {
                    logger.debug { "Click en Favorito: $it" }
                    viewModel.setFavoriteFilm(it)
                }
            )
        }
    }
}