package fhnw.emoba.modules.module08.startrek

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module08.startrek.model.StarTrekModel
import fhnw.emoba.modules.module08.startrek.ui.StarTrekUI

object StarTrekApp  : EmobaApp {

    private lateinit var model: StarTrekModel

    override fun initialize(activity: ComponentActivity) {
        model = StarTrekModel(activity)
    }

    @Composable
    override fun CreateUI() {
        StarTrekUI(model)
    }

}