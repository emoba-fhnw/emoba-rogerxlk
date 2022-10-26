package fhnw.emoba.modules.module06.weather_solution.ui

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import fhnw.emoba.modules.module06.weather_solution.model.Screen
import fhnw.emoba.modules.module06.weather_solution.model.WeatherModel
import fhnw.emoba.modules.module06.weather_solution.ui.screens.CitiesScreen
import fhnw.emoba.modules.module06.weather_solution.ui.theme.WeatherAppTheme


@Composable
fun WeatherUI(model: WeatherModel) {
    with(model) {
        WeatherAppTheme(isDarkTheme) {
            Crossfade(targetState = currentScreen) { screen ->
                when (screen) {
                    Screen.WEATHER -> {
                        WeatherScreen(model)
                    }
                    Screen.CITIES -> {
                        CitiesScreen(model)
                    }
                }
            }
        }
    }
}