package fhnw.emoba.modules.module11.goofieball

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module11.goofieball.model.GoofieBallModel
import fhnw.emoba.modules.module11.goofieball.ui.GoovieBallUI

object GoofieBall : EmobaApp {
    private lateinit var model: GoofieBallModel

    override fun initialize(activity: ComponentActivity) {
        model = GoofieBallModel(activity)
    }

    @Composable
    override fun CreateUI() {
        GoovieBallUI(model)
    }
}