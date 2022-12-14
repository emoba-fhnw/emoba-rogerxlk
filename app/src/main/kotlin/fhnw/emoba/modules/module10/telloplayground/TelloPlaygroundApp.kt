package fhnw.emoba.modules.module10.telloplayground

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module10.telloplayground.data.TelloConnector
import fhnw.emoba.modules.module10.telloplayground.model.TelloModel
import fhnw.emoba.modules.module10.telloplayground.ui.TelloUI

object TelloPlaygroundApp : EmobaApp {
    private lateinit var model: TelloModel

    override fun initialize(activity: ComponentActivity) {
        val realTelloIpAddress   = "192.168.10.1"
        val realTelloCommandPort = 8889
        val realTelloStatePort   = 8890
        val realTelloVideoPort   = 11111

        val connector = TelloConnector(ip          = "10.223.13.208",
                                       commandPort = 8889,
                                       statePort   = 8890)
        model = TelloModel(connector)
    }

    @Composable
    override fun CreateUI() {
        TelloUI(model)
    }

}