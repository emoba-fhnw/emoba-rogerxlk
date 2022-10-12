package fhnw.emoba.modules.module04.tabs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module04.tabs.model.TabsModel

@Composable
fun TabsUI(model: TabsModel) {
    MaterialTheme {
        Scaffold(topBar                       = { Bar(model) },
                 floatingActionButton         = { FAB(model) },
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
    with(model){
        //TODO: mit TabsRow und Tab ersetzen
        Text("to be replaced")

        //TODO: Kommentare entfernen
        //ContentBox(tabContent = selectedTab)
    }

}

@Composable
private fun FAB(model: TabsModel) {
    //TODO: ergaenzen mit FloatingActionButton
}

//todo: Kommentare entfernen sobald 'AvailableTabs' fertig ist

//@Composable
//private fun ContentBox(tabContent: AvailableTabs) {
//    Box(
//        modifier = Modifier.fillMaxSize().background(Color.Black),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(0), //TODO: ergaenzen mit richtigem Inhalt
//            contentDescription = "?", //TODO: ergaenzen mit sinnvollem Inhalt
//            modifier = Modifier.fillMaxSize().padding(30.dp)
//        )
//    }
//}