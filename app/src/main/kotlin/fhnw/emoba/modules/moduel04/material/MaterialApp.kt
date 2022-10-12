package fhnw.emoba.modules.module04.material

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.material.model.MaterialModel
import fhnw.emoba.modules.module04.material.ui.MaterialUI

object MaterialApp : EmobaApp {
    private lateinit var model: MaterialModel
    
    override fun initialize(activity: ComponentActivity) {
        model = MaterialModel
    }
    
    @Composable
    override fun CreateUI() {
        MaterialUI(model)
    }
}