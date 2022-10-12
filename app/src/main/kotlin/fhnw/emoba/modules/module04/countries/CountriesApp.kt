package fhnw.emoba.modules.module04.countries

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module04.countries.model.CountriesModel
import fhnw.emoba.modules.module04.countries.ui.CountriesUI

object CountriesApp : EmobaApp {
    private lateinit var model: CountriesModel
    
    override fun initialize(activity: ComponentActivity) {
        model = CountriesModel
        //todo: Bereitstellen der anzuzeigenden Laender, Kommentar entfernen.
         model.loadCountries()
    }
    
    @Composable
    override fun CreateUI() {
        CountriesUI(model)
    }
}