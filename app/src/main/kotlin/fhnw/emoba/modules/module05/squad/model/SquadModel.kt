package fhnw.emoba.modules.module05.squad.model

import fhnw.emoba.modules.module05.squad.data.Squad
import fhnw.emoba.modules.module05.squad.data.SquadRepository

class SquadModel(private val repo : SquadRepository) {  //warum sollte das repo auf jeden Fall private sein?
    val title = "The Squad App"
    
    val squad: Squad
    get() = repo.squad
}