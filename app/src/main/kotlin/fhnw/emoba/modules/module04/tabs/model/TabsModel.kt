package fhnw.emoba.modules.module04.tabs.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module04.tabs.model.enum.AvailableTabs

object TabsModel {
    val title = "Tabs Example App"
    
    // todo: was wird benoetigt fuer den Praesentationszustand?
    var selectedTab by mutableStateOf(AvailableTabs.FIRST)

}