package fhnw.emoba.modules.module05.multiple_screens.ui.screens

import kotlinx.coroutines.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module05.multiple_screens.model.MultipleScreensModel
import fhnw.emoba.modules.module05.multiple_screens.model.Screen


@Composable
fun DefaultTopBar(
    model: MultipleScreensModel,
    screen: Screen,
    lastScreen: Screen? = null,
    nextScreen: Screen? = null
) {
    with(model) {
        TopAppBar(
            title = { Text(screen.title) },
            navigationIcon = {
                if (lastScreen != null) {
                    BackToScreenIcon(this, lastScreen)
                }
            },
            actions = {
                if (nextScreen != null) {
                    IconButton(onClick = { }) {  //todo
                        Icon(Icons.Filled.ArrowForward, "ArrowForward")
                    }
                }
            }
        )
    }
}

@Composable
fun DefaultScreen(
    model: MultipleScreensModel,
    screen: Screen,
    lastScreen: Screen? = null,
    nextScreen: Screen? = null
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                model = model,
                screen = screen,
                lastScreen = lastScreen,
                nextScreen = nextScreen
            )
        },
        floatingActionButton = { GoHomeFAB(model) },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        DefaultBody(screen, it)
    }
}

@Composable
fun DrawerIcon(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()

    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
        Icon(Icons.Filled.Menu, "Menu")
    }
}

@Composable
fun BackToScreenIcon(model: MultipleScreensModel, screen: Screen) {
    with(model) {
        IconButton(onClick = { }) {  //todo: auf vorgängigen Screen wechseln
            Icon(Icons.Filled.ArrowBack, "Back")
        }
    }
}

@Composable
fun DefaultBody(screen: Screen, paddingValues: PaddingValues) {
    Box(contentAlignment = Alignment.Center,
        modifier         = Modifier.padding(paddingValues)
                                   .padding(15.dp)
                                   .fillMaxSize())
    {
        Image(
            painter = painterResource(screen.resId),
            contentDescription = screen.title,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(20.dp))
        )
    }
}

@Composable
fun GoHomeFAB(model: MultipleScreensModel) {
    with(model) {
        FloatingActionButton(
            onClick = {}  //todo: auf Home Screen wechseln
        ) { Icon(Icons.Filled.Home, "Home") }
    }
}

@Composable
fun Drawer(model: MultipleScreensModel) {
    Column {
        DrawerRow(model, Screen.HOME)
        DrawerRow(model, Screen.YEAR_1955)
        DrawerRow(model, Screen.YEAR_2015)
        DrawerRow(model, Screen.ABOUT)
    }
}

@Composable
fun DrawerRow(model: MultipleScreensModel, screen: Screen) {
    with(model) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = screen.resId),
                contentDescription = screen.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(text = screen.title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .clickable(onClick = { })
            ) //todo
        }
        Divider()
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
private fun DrawerPreview() {
    Drawer(model = MultipleScreensModel)
}