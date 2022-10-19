package fhnw.emoba.modules.module05.multiple_screens.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel

@Composable
fun MultipleScreensUI(model: MultipleScreensModel) {
    with(model) {
        MaterialTheme {
            Text("to be replaced") // Todo: durch Crossfade ersetzen mit dem aktuellen Screen als 'targetState'
            
            //https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#crossfade
        }
    }
}