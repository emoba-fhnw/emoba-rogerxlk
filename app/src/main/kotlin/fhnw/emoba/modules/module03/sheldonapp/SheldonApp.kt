package fhnw.emoba.modules.module03.sheldonapp

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module03.sheldonapp.ui.SheldonUI

object SheldonApp : EmobaApp {

    lateinit var title : String

    override fun initialize(activity: ComponentActivity) {
        title = "Sheldon Cooper"
    }

    @Composable
    override fun CreateUI() {
        SheldonUI(title)
    }
}