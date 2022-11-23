package fhnw.emoba.modules.module09.gps

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module09.gps.data.GPSConnector
import fhnw.emoba.modules.module09.gps.model.GpsModel
import fhnw.emoba.modules.module09.gps.ui.GpsUI

object GpsApp : EmobaApp {
    private lateinit var model: GpsModel

    override fun initialize(activity: ComponentActivity) {
        val gps = GPSConnector(activity)
        model = GpsModel(activity, gps)
    }

    @Composable
    override fun CreateUI() {
        GpsUI(model)
    }
}