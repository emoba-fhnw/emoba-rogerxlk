package fhnw.emoba.modules.module06.weather_solution.data.impl

import org.json.JSONObject
import android.graphics.Bitmap
import fhnw.emoba.modules.module06.weather_solution.data.City
import fhnw.emoba.modules.module06.weather_solution.data.DEFAULT_ICON
import fhnw.emoba.modules.module06.weather_solution.data.Forecast
import fhnw.emoba.modules.module06.weather_solution.data.WeatherService
import fhnw.emoba.modules.module06.weather_solution.data.bitmap
import fhnw.emoba.modules.module06.weather_solution.data.content

/**
 * https://openweathermap.org/api/one-call-api
 */
class RemoteWeatherService : WeatherService {

    override fun requestForecast(city: City): Forecast {
        val baseURL = "https://api.openweathermap.org/data/2.5/onecall"
        val apiKey =
            "da050e1da82bb32f9846b2340d0d2b75" // get your own https://home.openweathermap.org/users/sign_up
        val exclude = "minutely,daily"
        val lang = "de"
        val units = "metric"
        val longitude = city.coordinates.longitude
        val latitude = city.coordinates.latitude

        try {
            val url =
                "$baseURL?lon=$longitude&lat=$latitude&exclude=$exclude&lang=$lang&units=$units&APPID=$apiKey"

            return Forecast(city, content(url))
        } catch (e: Exception) {
            //todo: Handle exception correctly
            return Forecast(city, JSONObject())
        }
    }

    override fun requestWeatherIcon(icon: String, size: Int): Bitmap {
        var key = icon
        if (size > 1) {
            key += "@${size}x"
        }
        try {
            return bitmap("https://openweathermap.org/img/wn/$key.png")
        } catch (e: Exception) {
            return DEFAULT_ICON
        }
    }
}