package fhnw.emoba.modules.module05.template

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module05.template.model.TemplateModel
import fhnw.emoba.modules.module05.template.ui.AppUI


object TemplateApp : EmobaApp {

    override fun initialize(activity: ComponentActivity) {
    }

    @Composable
    override fun CreateUI() {
        AppUI(TemplateModel)
    }

}