package fhnw.emoba.modules.module05.multiple_screens.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen
import fhnw.emoba.modules.module05.multiple_screens.ui.screens.AboutScreen
import fhnw.emoba.modules.module05.multiple_screens.ui.screens.HomeScreen
import fhnw.emoba.modules.module05.multiple_screens.ui.screens.Year1955Screen
import fhnw.emoba.modules.module05.multiple_screens.ui.screens.Year2015Screen

@Composable
fun MultipleScreensUI(model: MultipleScreensModel) {
    with(model) {
        MaterialTheme {
            Text("to be replaced") // Todo: durch Crossfade ersetzen mit dem aktuellen Screen als 'targetState'

            when (currentScreen) {
                Screen.HOME -> {
                    HomeScreen(model = model)
                }
                Screen.YEAR_1955 -> {
                    Year1955Screen(model = model)
                }
                Screen.YEAR_2015 -> {
                    Year2015Screen(model = model)
                }
                else -> {
                    AboutScreen(model = model)
                }
            }
            //https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#crossfade
        }
    }
}