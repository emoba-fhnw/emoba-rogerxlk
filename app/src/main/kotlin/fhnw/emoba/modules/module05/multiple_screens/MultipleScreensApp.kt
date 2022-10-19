package fhnw.emoba.modules.module05.multiple_screens

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.ui.MultipleScreensUI

object MultipleScreensApp : EmobaApp {
    
    private lateinit var model : MultipleScreensModel
    
    override fun initialize(activity: ComponentActivity) {
        model= MultipleScreensModel
    }
    
    @Composable
    override fun CreateUI() {
        MultipleScreensUI(model)
    }
}