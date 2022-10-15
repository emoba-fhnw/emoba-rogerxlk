package fhnw.emoba.modules.module04.beers

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.beers.model.BeersAppModel
import fhnw.emoba.modules.module04.beers.ui.BeersAppUI

object BeersApp : EmobaApp {

    private lateinit var model : BeersAppModel
    
    override fun initialize(activity: ComponentActivity) {
        model = BeersAppModel
        //what is needed?
        model.loadBeers()
    }

    @Composable
    override fun CreateUI() {
        BeersAppUI(model)
    }
}