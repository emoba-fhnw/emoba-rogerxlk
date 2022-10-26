package fhnw.emoba.modules.module06.weather_solution.data

import java.util.Locale
import android.content.Context

class CityRepository(context: Context) {
    private val CH = Locale("de", "CH")
    private val CITIES_FILE_NAME = "citylist.json"

    val data = dataListFrom(CITIES_FILE_NAME, context) { City(it) }

    fun getCity(id: Int): City = data.filter { it.id == id }.first()

    fun search(nameFilter: String, countryCodeFilter: String): List<City> =
        when {
            nameFilter.isBlank() -> emptyList()
            else -> data.filter {
                it.name.lowercase(CH).contains(nameFilter.lowercase(CH)) &&
                        countryCodeFilter.contains(it.countryCode)
            }
        }
}