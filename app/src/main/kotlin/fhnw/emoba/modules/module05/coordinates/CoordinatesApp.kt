package fhnw.emoba.modules.module05.coordinates

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module05.coordinates.model.CoordinatesModel
import fhnw.emoba.modules.module05.coordinates.ui.CoordinatesUI

object CoordinatesApp : EmobaApp {
    private lateinit var model : CoordinatesModel
    
    override fun initialize(activity: ComponentActivity) {
        model = CoordinatesModel
    }
    
    @Composable
    override fun CreateUI() {
        CoordinatesUI(model = CoordinatesModel)
    }
}