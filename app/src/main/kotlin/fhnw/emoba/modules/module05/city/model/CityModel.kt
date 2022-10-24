package fhnw.emoba.modules.module05.city.model

import fhnw.emoba.modules.module05.city.data.City
import fhnw.emoba.modules.module05.city.data.CityRepository

class CityModel(private val repo : CityRepository) {
    val title = "Find your City"

    val cities: List<City>
    get() = repo.cities

}
