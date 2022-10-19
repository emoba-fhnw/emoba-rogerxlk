package fhnw.emoba.modules.module04.tabs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module04.tabs.model.enum.AvailableTabs
import fhnw.emoba.modules.module04.tabs.model.TabsModel

@Composable
fun TabsUI(model: TabsModel) {
    MaterialTheme {
        Scaffold(
            topBar = { Bar(model) },
            floatingActionButton = { FAB(model) },
            floatingActionButtonPosition = FabPosition.End,
            content = { padding ->
                Body(model, padding)
            },
        )
    }
}

@Composable
private fun Bar(model: TabsModel) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: TabsModel, padding: PaddingValues) {
    with(model) {
        //TODO: mit TabsRow und Tab ersetzen !!Image Doesnt work yet!!
        var state by remember { mutableStateOf(0) }
        val titles = model.availableTabs
        Column {
            TabRow(selectedTabIndex = state) {
                titles.forEachIndexed { index, tab ->
                    Tab(
                        text = { Text(tab.title) },
                        selected = tab == selectedTab,
                        onClick = { index }
                    )
                }
            }
//            TODO: Kommentare entfernen
            ContentBox(tabContent = selectedTab)
        }
    }

}

@Composable
private fun FAB(model: TabsModel) {
    //TODO:ergaenzen mit FloatingActionButton
    FloatingActionButton(onClick = { "TBD" }) {
        Icon(Icons.Filled.Home, contentDescription = "Go to Home")
    }
}

//Kommentare entfernen sobald 'AvailableTabs' fertig ist
@Composable
private fun ContentBox(tabContent: AvailableTabs) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(tabContent.imageInt), //ergaenzen mit richtigem Inhalt
            contentDescription = tabContent.title, //ergaenzen mit sinnvollem Inhalt
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        )
    }
}