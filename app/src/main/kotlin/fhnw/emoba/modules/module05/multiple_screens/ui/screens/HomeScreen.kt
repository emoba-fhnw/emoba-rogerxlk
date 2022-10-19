package fhnw.emoba.modules.module05.multiple_screens.ui.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen

@Composable
fun HomeScreen(model: MultipleScreensModel) {
    val scaffoldState = rememberScaffoldState()
    
    Scaffold(scaffoldState = scaffoldState,
             topBar        = { HomeTopBar(model, scaffoldState) },
             drawerContent = { Drawer(model) }
    ){
        DefaultBody(Screen.HOME, it)
    }
}

@Composable
private fun HomeTopBar(model: MultipleScreensModel, scaffoldState: ScaffoldState) {
    with(model) {
        TopAppBar(
                title          = { Text(Screen.HOME.title) },
                navigationIcon = { DrawerIcon(scaffoldState = scaffoldState) },
                actions        = { IconButton(onClick = { currentScreen = Screen.YEAR_1955}) { //todo: auf naechsten Screen wechseln
                    Icon(Icons.Filled.ArrowForward, "")
                }
                }
        )
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen(MultipleScreensModel)
}