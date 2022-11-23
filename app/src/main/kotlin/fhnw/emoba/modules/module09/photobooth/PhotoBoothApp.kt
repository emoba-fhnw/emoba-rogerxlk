package fhnw.emoba.modules.module09.photobooth

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module09.photobooth.data.CameraAppConnector
import fhnw.emoba.modules.module09.photobooth.model.PhotoBooth
import fhnw.emoba.modules.module09.photobooth.ui.PhotoBootUI

object PhotoBoothApp : EmobaApp{
    private lateinit var model: PhotoBooth

    override fun initialize(activity: ComponentActivity) {
        val cameraAppConnector = CameraAppConnector(activity)
        model = PhotoBooth(cameraAppConnector)
    }

    @Composable
    override fun CreateUI() {
        PhotoBootUI(model)
    }

}