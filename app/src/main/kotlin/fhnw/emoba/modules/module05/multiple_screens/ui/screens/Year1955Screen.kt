package fhnw.emoba.modules.module05.multiple_screens.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen

@Composable
fun Year1955Screen(model: MultipleScreensModel) {
    DefaultScreen(
        model = model,
        screen = Screen.YEAR_1955,
        lastScreen = Screen.HOME,
        nextScreen = Screen.YEAR_2015
    )

    BackHandler(enabled = true, onBack = {
        // zurück in die Gegenwart (nach Hause)
        model.currentScreen = Screen.HOME
    })
}

@Preview(device = Devices.PIXEL_4)
@Composable
private fun ScreenPreview() {
    Year1955Screen(model = MultipleScreensModel)
}