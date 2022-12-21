package fhnw.emoba.modules.module11.canvasplayground

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module11.canvasplayground.ui.CanvasPane

object CanvasPlaygroundApp : EmobaApp {

    override fun initialize(activity: ComponentActivity) {
    }

    @Composable
    override fun CreateUI() {
        CanvasPane()
    }
}