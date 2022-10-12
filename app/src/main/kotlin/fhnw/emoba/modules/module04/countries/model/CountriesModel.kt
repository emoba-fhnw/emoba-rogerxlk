package fhnw.emoba.modules.module04.countries.model

import fhnw.emoba.modules.module04.countries.data.Country
import fhnw.emoba.modules.module04.countries.data.Repository


object CountriesModel {
    val  title = "Länder in Europa"

//todo: Kommentare entfernen, Imports ergaenzen. Es duerfen dann keine Compile-Fehler auftreten.

    lateinit var countries: List<Country>

    fun loadCountries(){
        countries = Repository.countries
    }
    
    //wo sollte loadCountries aufgerufen werden? -> Initializer!
}