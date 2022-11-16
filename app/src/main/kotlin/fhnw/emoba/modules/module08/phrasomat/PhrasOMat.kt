package fhnw.emoba.modules.module08.phrasomat

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module08.phrasomat.model.PhrasOMatModel
import fhnw.emoba.modules.module08.phrasomat.ui.PhrasOMatUI

object PhrasOMat  : EmobaApp {
    private lateinit var model: PhrasOMatModel

    override fun initialize(activity: ComponentActivity) {
        model = PhrasOMatModel
    }

    @Composable
    override fun CreateUI() {
        PhrasOMatUI(model)
    }

}
