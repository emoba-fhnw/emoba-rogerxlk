package fhnw.emoba.modules.module04.viewmodel

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.viewmodel.model.CounterModel
import fhnw.emoba.modules.module04.viewmodel.ui.View

object ViewModelApp: EmobaApp {

    //beim starten einer App, kann durch lateinit der StartProzess optimiert werden
    lateinit var model : CounterModel

    override fun initialize(activity: ComponentActivity) {
        model = CounterModel()
    }
    
    @Composable
    override fun CreateUI() {
        View(model)  // ein View braucht  ein Model
    }
}