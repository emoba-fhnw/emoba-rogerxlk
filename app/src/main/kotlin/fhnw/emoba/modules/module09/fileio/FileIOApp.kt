package fhnw.emoba.modules.module09.fileio

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module09.fileio.model.FileIOModel
import fhnw.emoba.modules.module09.fileio.ui.FileIOUI

object FileIOApp : EmobaApp {
    lateinit var model : FileIOModel

    override fun initialize(activity: ComponentActivity) {
        model = FileIOModel(activity)
    }

    @Composable
    override fun CreateUI() {
        FileIOUI(model)
    }
}