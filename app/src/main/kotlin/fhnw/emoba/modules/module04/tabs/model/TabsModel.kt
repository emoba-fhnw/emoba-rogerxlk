package fhnw.emoba.modules.module04.tabs.model

import fhnw.emoba.modules.module04.tabs.enum.AvailableTabs

object TabsModel {
    val title = "Tabs Example App"
    
    // todo: was wird benoetigt fuer den Praesentationszustand?
    lateinit var availableTabs : List<AvailableTabs>
    lateinit var selectedTab: AvailableTabs

    fun loadAvailableTabs(){
        availableTabs = AvailableTabs.values().asList()
    }
}