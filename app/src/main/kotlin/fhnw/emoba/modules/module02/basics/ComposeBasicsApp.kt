package fhnw.emoba.modules.module02.basics

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module02.basics.ui.BasicsUI

object ComposeBasicsApp : EmobaApp {
    
    lateinit var title : String
    
    override fun initialize(activity: ComponentActivity) {
        title = "JetPack Compose Basics"
    }
    
    @Composable
    override fun CreateUI() {
        BasicsUI(title)
    }
    
}