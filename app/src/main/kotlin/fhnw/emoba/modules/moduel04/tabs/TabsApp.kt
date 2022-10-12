package fhnw.emoba.modules.module04.tabs

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.tabs.model.TabsModel
import fhnw.emoba.modules.module04.tabs.ui.TabsUI

object TabsApp : EmobaApp {
    private lateinit var model: TabsModel
    
    override fun initialize(activity: ComponentActivity) {
        model = TabsModel
    }
    
    @Composable
    override fun CreateUI() {
        TabsUI(model)
    }
}