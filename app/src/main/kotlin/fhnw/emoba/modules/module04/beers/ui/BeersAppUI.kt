package fhnw.emoba.modules.module04.beers.ui

import androidx.compose.foundation.Image
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.modules.module04.beers.data.Beer
import fhnw.emoba.modules.module04.beers.model.BeersAppModel
import fhnw.emoba.modules.module04.beers.ui.theme.BeersTheme
import fhnw.emoba.modules.module04.countries.ui.CountryPane

@Composable
fun BeersAppUI(model: BeersAppModel) {
    val scaffoldState = rememberScaffoldState()

    with(model) {
        BeersTheme(darkTheme) { // wie kann das umschaltbar gemacht werden
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
    //Schauen Sie sich genau an wie der Drawer eingeblendet wird. Wir werden
    // das noch haeufiger brauchen
    val scope = rememberCoroutineScope()
    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
        Icon(Icons.Filled.Menu, "Drawer öffnen")
    }
}

@Composable
private fun Body(model: BeersAppModel, paddingValues: PaddingValues) {
    with(model) {
        //todo: Visualisierung aller Movies. Verwenden Sie 'LazyColumn'  und 'BeerCard'
        LazyColumn {
            items(model.beers) {
                BeerCard(beer = it)
            }
        }
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

        //Fuegen Sie einen 'Switch' und entsprechenden 'Text' hinzu mit dem das Theme um
        // geschaltet werden kann.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Dark Theme",
                modifier = Modifier.padding(6.dp),
                fontSize = 16.sp
            )
            Switch(checked = darkTheme,
                onCheckedChange = { toggleTheme() }
            )
        }
        Divider()
    }
}


//implementieren Sie die Funktion, die ein einzelnes Bier visualisiert
@Composable
private fun BeerCard(beer: Beer) {
    with(beer){
        BeerImage(beer = beer)
        Headline(text = beer.title)
        SubTitle(text = "Vote: ${beer.voteAverage}")
        Caption(text = beer.overview)
        Link(url = beer.link)
    }
}


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
private fun BeerImage(beer: Beer) {
    //was soll BeerImage bekommen?
    with(beer) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painterResource(imageId), title)
        }
    }
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