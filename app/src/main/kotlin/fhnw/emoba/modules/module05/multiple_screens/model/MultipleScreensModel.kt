package fhnw.emoba.modules.module05.multiple_screens.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object MultipleScreensModel {
    // todo: was wird fuer den Status benoetigt?

    var currentScreen by mutableStateOf(Screen.HOME)
    
}