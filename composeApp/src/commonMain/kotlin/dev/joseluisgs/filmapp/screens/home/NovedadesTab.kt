package dev.joseluisgs.filmapp.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Film
import dev.joseluisgs.filmapp.Res
import org.lighthousegames.logging.logging

private val logger = logging()

object NovedadesTab : Tab {

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
        HomeView()
    }
}