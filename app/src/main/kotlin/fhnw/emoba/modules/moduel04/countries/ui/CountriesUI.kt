package fhnw.emoba.modules.module04.countries.ui

import java.util.Locale
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fhnw.emoba.modules.module04.countries.model.CountriesModel

@Composable
fun CountriesUI(model: CountriesModel) {
    //Alternative falls man nur wenig am Theme aendern will
    MaterialTheme(colors = lightColors(primary   = Color(0xFF003399),
                                       onPrimary = Color(0xFFFFCC00),
                                       surface   = Color(0xFFE5F7FF) //z.B. Background einer Card
    )) {
        Scaffold(topBar  = { Bar(model) },
                 content = { Body(model, it) })
    }
}

@Composable
private fun Bar(model: CountriesModel){
    with(model){
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: CountriesModel, paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues).fillMaxSize(),
        contentAlignment = Alignment.Center){

        Text("To be replaced")
        
    // Todo: Verwenden Sie 'LazyColumn'
    // https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/package-summary#lazycolumn
    }
}

// Todo: Implementieren Sie eine Funktion, die ein einzelnes Country visualisiert
//  verwenden Sie 'Card'
//  https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#card

//@Composable
//fun CountryPane(country: Country) {
//
//}


//Todo: verwenden Sie diese Funktion an geeigneter Stelle
@Composable
private fun Heading(text: String) {
    Text(text = text,
         style = MaterialTheme.typography.h3)
}

@Composable
private fun Subheading(text: String, modifier: Modifier) {
    Text(text     = text,
         style    = MaterialTheme.typography.subtitle1,
         modifier = modifier
    )
}

// eine  praktische Extension-Function zum Formatieren einer Zahl
private fun Number.format(formatPattern: String) = formatPattern.format(CH, this)

private val CH = Locale("de", "CH")


//todo : Kommentare entfernen sobald Country und CountryPane vorhanden sind

//@Preview(name = "Single Country Card")
//@Composable
//private fun Preview(){
//    val lummerland = Country("Lummerland", 0.12, 5)
//    CountryPane(lummerland)
//}