package fhnw.emoba.modules.module03.sheldonapp

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module03.funwithflaggsapp.ui.FunWithFlagsUI

object FunWithFlagsApp : EmobaApp {

    lateinit var title : String

    override fun initialize(activity: ComponentActivity) {
        title = "Fun with Flags"
    }

    @Composable
    override fun CreateUI() {
        FunWithFlagsUI(title)
    }
}