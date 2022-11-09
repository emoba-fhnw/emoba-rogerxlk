package fhnw.emoba.modules.module07.flutter

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module07.flutter.model.FlutterModel
import fhnw.emoba.modules.module07.flutter.ui.FlutterUI

object FlutterApp: EmobaApp {
    private lateinit var model : FlutterModel

    override fun initialize(activity: ComponentActivity) {
        model = FlutterModel
        model.connectAndSubscribe()
    }

    @Composable
    override fun CreateUI() {
        FlutterUI(model)
    }
}