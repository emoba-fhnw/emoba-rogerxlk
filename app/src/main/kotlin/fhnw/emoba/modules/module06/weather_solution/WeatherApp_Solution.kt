package fhnw.emoba.modules.module06.weather_solution

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module06.weather_solution.data.CityRepository
import fhnw.emoba.modules.module06.weather_solution.data.impl.RemoteWeatherService
import fhnw.emoba.modules.module06.weather_solution.model.WeatherModel
import fhnw.emoba.modules.module06.weather_solution.ui.WeatherUI

object WeatherApp_Solution : EmobaApp {
    private lateinit var model: WeatherModel

    override fun initialize(activity: ComponentActivity) {
        val citiesRepo = CityRepository(activity)
        val weatherService = RemoteWeatherService()
        //val weatherService = LocalWeatherService(activity)
        model = WeatherModel(citiesRepo, weatherService)
        model.getForecastsOfFavoritesAsync()
    }

    @Composable
    override fun CreateUI() {
        WeatherUI(model)
    }
}