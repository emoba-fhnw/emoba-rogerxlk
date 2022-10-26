package fhnw.emoba.modules.module06.morefunwithflags

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module06.morefunwithflags.data.impl.LocalFlagService
import fhnw.emoba.modules.module06.morefunwithflags.model.MoreFunWithFlagsModel
import fhnw.emoba.modules.module06.morefunwithflags.ui.MoreFunWithFlagsUI

object MoreFunWithFlagsApp : EmobaApp {
    private lateinit var model: MoreFunWithFlagsModel
    
    override fun initialize(activity: ComponentActivity) {
        val flagService = LocalFlagService(activity)
        model = MoreFunWithFlagsModel(flagService)
    }
    
    @Composable
    override fun CreateUI() {
        MoreFunWithFlagsUI(model)
    }
}