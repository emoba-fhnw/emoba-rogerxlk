package fhnw.emoba.modules.module04.beers.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module04.beers.data.Beer
import fhnw.emoba.modules.module04.beers.data.Repository


object BeersAppModel {
    val title = "Popular Beers"

    // Welche Properties werden benoetigt
    // - damit zwischen Dark-Theme und Light-Theme gewechselt werden kann
    var darkTheme by mutableStateOf(false)
        private set

    fun toggleTheme(){
        darkTheme = !darkTheme
    }

    // - fuer die Daten (in diesem Fall Beers)
    lateinit var beers: List<Beer>

    fun loadBeers() {
        beers = Repository.beers
    }



}