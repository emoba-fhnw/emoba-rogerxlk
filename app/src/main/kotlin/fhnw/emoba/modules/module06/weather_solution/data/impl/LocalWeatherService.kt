package fhnw.emoba.modules.module06.weather_solution.data.impl

import org.json.JSONObject
import android.content.Context
import android.graphics.Bitmap
import fhnw.emoba.modules.module06.weather_solution.data.City
import fhnw.emoba.modules.module06.weather_solution.data.DEFAULT_ICON
import fhnw.emoba.modules.module06.weather_solution.data.Forecast
import fhnw.emoba.modules.module06.weather_solution.data.WeatherService
import fhnw.emoba.modules.module06.weather_solution.data.content

class LocalWeatherService(val context: Context) : WeatherService {
    override fun requestForecast(city: City): Forecast =
        Forecast(city, JSONObject(content("forecast-brugg.json", context)))

    override fun requestWeatherIcon(icon: String, size: Int): Bitmap = DEFAULT_ICON
}