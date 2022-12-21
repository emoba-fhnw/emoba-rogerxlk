package fhnw.emoba.modules.module11.led

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module11.led.model.LedModel
import fhnw.emoba.modules.module11.led.ui.LedAppUI

object LedApp : EmobaApp {
    private lateinit var  model: LedModel

    override fun initialize(activity: ComponentActivity) {
        model = LedModel
    }

    @Composable
    override fun CreateUI() {
       LedAppUI(model)
    }
}