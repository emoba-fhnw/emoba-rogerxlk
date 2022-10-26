package fhnw.emoba.modules.module06.anthems_solution

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module06.anthems.model.AnthemsModel
import fhnw.emoba.modules.module06.anthems.ui.AnthemsUI

object AnthemsApp : EmobaApp {
    override fun initialize(activity: ComponentActivity) {
    }
    
    @Composable
    override fun CreateUI() {
        AnthemsUI(AnthemsModel)
    }
}