package fhnw.emoba.modules.module04.viewmodel.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

class CounterModel {

    val title = "UI needs State - "

    var counter by mutableStateOf(0)

    fun increase(){
        counter++
    }

    fun reset() {
        counter = 0
    }

    fun decrease() {
        counter--
    }

}