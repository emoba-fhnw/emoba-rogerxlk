package fhnw.emoba.modules.module04.material.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object MaterialModel {
    // der Applikationsname bleibt unveraendert, also 'val'
    val title = "Material Design Example"
    
    // die Aenderung des Themes muss ein Recompose ausloesen, also 'mutableStateOf'
    var darkTheme by mutableStateOf(false)
    private set  // das Theme soll nur ueber toggleTheme geaendert werden koennen, also ist der setter 'private'

    var typoBig by mutableStateOf(false)
    private set
    
    //die "Business-Logik'
    fun toggleTheme(){
        darkTheme = !darkTheme
    }

    //die "Business-Logik'
    fun toggleFontSize(){
        typoBig = !typoBig
    }
}