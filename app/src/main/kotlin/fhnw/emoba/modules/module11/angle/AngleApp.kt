package fhnw.emoba.modules.module11.angle

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module11.angle.model.AngleModel
import fhnw.emoba.modules.module11.angle.ui.AngleUI

object AngleApp : EmobaApp {

    private lateinit var model : AngleModel

    override fun initialize(activity: ComponentActivity) {
        model = AngleModel
    }

    @Composable
    override fun CreateUI() {
        AngleUI(model)
    }
}