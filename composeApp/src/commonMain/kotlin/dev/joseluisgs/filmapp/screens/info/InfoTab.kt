package dev.joseluisgs.filmapp.screens.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Info
import dev.joseluisgs.filmapp.Res

object InfoTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = Res.string.tab_informacion
            val icon = rememberVectorPainter(FeatherIcons.Info)

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
        InfoView()
    }
}