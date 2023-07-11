package dev.joseluisgs.filmapp.screens.favoritos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Star
import dev.joseluisgs.filmapp.Res

object FavoritosTab : Tab {

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
        FavoritosView()
    }
}