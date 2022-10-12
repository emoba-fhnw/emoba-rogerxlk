package fhnw.emoba.modules.module04.beers.ui

import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module04.beers.model.BeersAppModel
import fhnw.emoba.modules.module04.beers.ui.theme.BeersTheme

@Composable
fun BeersAppUI(model: BeersAppModel) {
    val scaffoldState = rememberScaffoldState()

    with(model) {
        BeersTheme(false) { //todo: wie kann das umschaltbar gemacht werden
            Scaffold(scaffoldState = scaffoldState,
                topBar = { Bar(model, scaffoldState) },
                drawerContent = { Drawer(model) },
                content = { Body(model, it) }
            )
        }
    }
}

@Composable
private fun Bar(model: BeersAppModel, scaffoldState: ScaffoldState) {
    with(model) {
        TopAppBar(title = { Text(title) },
            navigationIcon = { DrawerIcon(scaffoldState) }
        )
    }
}

@Composable
private fun DrawerIcon(scaffoldState: ScaffoldState) {
    //todo: Schauen Sie sich genau an wie der Drawer eingeblendet wird. Wir werden
    // das noch haeufiger brauchen
    val scope = rememberCoroutineScope()
    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
        Icon(Icons.Filled.Menu, "Drawer öffnen")
    }
}

@Composable
private fun Body(model: BeersAppModel, paddingValues: PaddingValues) {
    with(model) {
        //todo: Visualisierung aller Movies. Verwenden Sie 'LazyColumn'  und 'MovieCard'
    }
}

@Composable
private fun Drawer(model: BeersAppModel) {
    with(model) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {
            Text(
                text = "Preferences",
                modifier = Modifier.padding(6.dp),
                style = MaterialTheme.typography.h6
            )
        }

        Divider()

        //todo: Fuegen Sie einen 'Switch' und entsprechenden 'Text' hinzu mit dem das Theme um
        // geschaltet werden kann.

        Divider()
    }
}


//todo: implementieren Sie die Funktion, die ein einzelnes Bier visualisiert
//@Composable
//private fun BeerCard(beer: Beer) {
//
//}



//einige Hilfsfunktionen, die Sie vielleicht brauchen koennen

@Composable
private fun Headline(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(all = 8.dp),
        style = MaterialTheme.typography.h6
    )
}

@Composable
private fun BeerImage() {
    //todo: was soll BeerImage bekommen?
   // with(beer) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.Center
        ) {
           // Image(painterResource(imageId), title)
        }
    //    }
}

@Composable
private fun SubTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .padding(8.dp)
    )
}

@Composable
private fun Link(url: String) {
    val uriHandler = LocalUriHandler.current
    Text(
        text = "read more...",
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .padding(8.dp)
            .clickable(
                onClick = {
                    uriHandler.openUri(
                        url
                    )
                })
    )
}

@Composable
private fun Caption(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(all = 8.dp),
        maxLines = 5,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.caption
    )
}