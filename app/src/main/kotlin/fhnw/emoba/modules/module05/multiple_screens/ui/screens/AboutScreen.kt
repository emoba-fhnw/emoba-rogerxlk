package fhnw.emoba.modules.module05.multiple_screens.ui.screens

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen

@Composable
fun AboutScreen(model: MultipleScreensModel){
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState                = scaffoldState,
             topBar                       = { AboutTopBar(scaffoldState) },
             drawerContent                = { Drawer(model) },
             floatingActionButton         = { GoHomeFAB(model) },
             floatingActionButtonPosition = FabPosition.End,
             isFloatingActionButtonDocked = true
    ){
        DefaultBody(Screen.ABOUT, it)
    }
}

@Composable
private fun AboutTopBar(scaffoldState: ScaffoldState) {
    TopAppBar(title          = { Text(Screen.ABOUT.title) },
              navigationIcon = { DrawerIcon(scaffoldState) }
    )
}

@Preview(device = Devices.PIXEL_4)
@Composable
private fun ScreenPreview(){
    AboutScreen(model = MultipleScreensModel)
}