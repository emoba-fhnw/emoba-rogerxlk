package fhnw.emoba.modules.module06.weather_solution.data

import android.graphics.Bitmap

val DEFAULT_ICON = Bitmap.createBitmap(
    120,
    120,
    Bitmap.Config.ALPHA_8
)

interface WeatherService {
    fun requestForecast(city: City): Forecast

    fun requestWeatherIcon(icon: String, size: Int = 1): Bitmap
}