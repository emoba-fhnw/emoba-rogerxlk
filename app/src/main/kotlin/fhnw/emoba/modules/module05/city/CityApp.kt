package fhnw.emoba.modules.module05.city

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module05.city.data.CityRepository
import fhnw.emoba.modules.module05.city.model.CityModel
import fhnw.emoba.modules.module05.city.ui.CityUI

object CityApp : EmobaApp {
    private lateinit var model: CityModel
    override fun initialize(activity: ComponentActivity) {
        val repo = CityRepository
        repo.loadSquad(activity)
        model = CityModel(repo)
    }

    @Composable
    override fun CreateUI() {
        CityUI(model)
    }

}