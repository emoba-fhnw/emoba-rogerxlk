package fhnw.emoba.modules.module06.weather_solution.model

import java.util.Collections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import fhnw.emoba.modules.module06.weather_solution.data.City
import fhnw.emoba.modules.module06.weather_solution.data.CityRepository
import fhnw.emoba.modules.module06.weather_solution.data.Forecast
import fhnw.emoba.modules.module06.weather_solution.data.WeatherService

class WeatherModel(val cityRepo: CityRepository, val weatherService: WeatherService) {

    private val weatherIconCache =
        Collections.synchronizedMap(LRUCache<Pair<String, Int>, ImageBitmap>(20))

    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val title = "WeatherApp"
    var isDarkTheme by mutableStateOf(true)

    var currentScreen by mutableStateOf(Screen.WEATHER)

    var searchtext by mutableStateOf("")

    var countryCH by mutableStateOf(true)
        private set

    fun toggleTheme() {
        isDarkTheme = !isDarkTheme
    }

    fun toggleCountryCH() {
        countryCH = !countryCH
        launchSearch()
    }

    var countryDE by mutableStateOf(false)
        private set

    fun toggleCountryDE() {
        countryDE = !countryDE
        launchSearch()
    }

    //results from searching the repo:
    var     currentCityList: List<City> by mutableStateOf(emptyList())

    var favoriteCities: List<City> by mutableStateOf(
        listOf(
            cityRepo.getCity(2661374), //Brugg
            cityRepo.getCity(2925177), //Freiburg
            cityRepo.getCity(2950159), //Berlin
            cityRepo.getCity(2911298), //Hamburg
            cityRepo.getCity(5128581), //New York City
            cityRepo.getCity(2147714), //Sidney
            cityRepo.getCity(8013441)  //Ponta Delgada (Azoren)
        )
    )

    var isLoading by mutableStateOf(false)
    var forecasts: List<Forecast> by mutableStateOf(emptyList())

    fun getForecastsOfFavoritesAsync() {
        isLoading = true
        forecasts = emptyList()
        modelScope.launch {
            forecasts = favoriteCities.map { weatherService.requestForecast(it) }
            isLoading = false

            forecasts.forEach { loadWeatherIconsAsync(it) }
        }
    }

    fun launchSearch() {
        var countryCodeFilter = ""
        if (countryCH) {
            countryCodeFilter += "CH,"
        }
        if (countryDE) {
            countryCodeFilter += "DE"
        }

        currentCityList = cityRepo.search(searchtext, countryCodeFilter)
    }

    fun addFavCity(favCity: City) {
        favoriteCities = favoriteCities.plus(favCity)
        //load new weather data for favCities
        getForecastsOfFavoritesAsync()
        searchtext = ""
    }

    fun removeFavCity(favCity: City) {
        favoriteCities = favoriteCities.minus(favCity)
        //load new weather data for favCities
        getForecastsOfFavoritesAsync()
    }

    private fun loadWeatherIconsAsync(forecast: Forecast) {
        modelScope.launch {
            forecast.current.weatherImage = getWeatherIcon(forecast.current.weatherIcon, 4)
        }
        forecast.nextHours.forEach {
            modelScope.launch {
                it.weatherImage = getWeatherIcon(it.weatherIcon, 2)
            }
        }
    }

    private fun getWeatherIcon(icon: String, size: Int): ImageBitmap {
        val key = Pair(icon, size)
        if (weatherIconCache[key] == null) {
            weatherIconCache[key] = weatherService.requestWeatherIcon(icon, size).asImageBitmap()
        }
        return weatherIconCache[key]!!
    }
}