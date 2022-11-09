package fhnw.emoba.modules.module07.mqtt

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module07.mqtt.model.MqttModel
import fhnw.emoba.modules.module07.mqtt.ui.MqttUI

object MqttApp : EmobaApp {
    private lateinit var model : MqttModel

    override fun initialize(activity: ComponentActivity) {
        model = MqttModel
        model.connectAndSubscribe()
    }
    
    @Composable
    override fun CreateUI() {
        MqttUI(model)
    }
}