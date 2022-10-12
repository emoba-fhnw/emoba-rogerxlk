package fhnw.emoba.modules.module04.viewmodel

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.viewmodel.ui.View

object ViewModelApp: EmobaApp {
    
    override fun initialize(activity: ComponentActivity) {
    }
    
    @Composable
    override fun CreateUI() {
        View()  // ein View braucht  ein Model
    }
}