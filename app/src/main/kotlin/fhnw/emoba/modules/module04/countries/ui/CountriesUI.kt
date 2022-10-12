package fhnw.emoba.modules.module04.countries.ui

import androidx.compose.foundation.layout.*
import java.util.Locale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module04.countries.data.Country
import fhnw.emoba.modules.module04.countries.model.CountriesModel

@Composable
fun CountriesUI(model: CountriesModel) {
    //Alternative falls man nur wenig am Theme ändern will
    MaterialTheme(
        colors = lightColors(
            primary = Color(0xFF003399),
            onPrimary = Color(0xFFFFCC00),
            surface = Color(0xFFE5F7FF) //z.B. Background einer Card
        )
    ) {
        Scaffold(topBar = { Bar(model) },
            content = { Body(model, it) })
    }
}

@Composable
private fun Bar(model: CountriesModel) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: CountriesModel, paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // Todo: Verwenden Sie 'LazyColumn'
        // https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/package-summary#lazycolumn
        with(model) {
            LazyColumn {
                items(model.countries) {
                    CountryPane(country = it)
                }
            }
        }
    }
}

// Todo: Implementieren Sie eine Funktion, die ein einzelnes Country visualisiert
//  verwenden Sie 'Card'
//  https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#card

@Composable
fun CountryPane(country: Country) {
    with(country) {
        Card(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Column() {
                Row(
                    modifier = Modifier.padding(10.dp),
                ) {
                    Heading(text = name)
                }
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Subheading(text = area.format("%.1f km2"), modifier = Modifier)
                    Subheading(text = population.toString() + " Einw.", modifier = Modifier)
                }
            }
        }
    }
}


//Todo: verwenden Sie diese Funktion an geeigneter Stelle
@Composable
fun Heading(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun Subheading(text: String, modifier: Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle1,
        modifier = modifier
    )
}


// eine  praktische Extension-Function zum Formatieren einer Zahl
val CH = Locale("de", "CH")
fun Number.format(formatPattern: String) = formatPattern.format(CH, this)


//todo : Kommentare entfernen sobald Country und CountryPane vorhanden sind
@Preview(name = "Single Country Card")
@Composable
private fun Preview() {
    val lummerland = Country("Lummerland", 0.12, 5)
    CountryPane(lummerland)
}