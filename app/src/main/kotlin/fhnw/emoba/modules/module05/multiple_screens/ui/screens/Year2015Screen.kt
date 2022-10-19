package fhnw.emoba.modules.module05.multiple_screens.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen

@Composable
fun Year2015Screen(model: MultipleScreensModel) {
    DefaultScreen(
        model = model,
        screen = Screen.YEAR_2015,
        lastScreen = Screen.YEAR_1955
    )

    BackHandler(enabled = true) {
        //TODO zurück ins Jahr 1955
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
private fun ScreenPreview() {
    Year2015Screen(model = MultipleScreensModel)
}