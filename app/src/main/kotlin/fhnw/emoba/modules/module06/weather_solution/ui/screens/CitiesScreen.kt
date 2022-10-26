package fhnw.emoba.modules.module06.weather_solution.ui.screens

import java.util.Locale
import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.modules.module06.weather_solution.data.City
import fhnw.emoba.modules.module06.weather_solution.model.Screen
import fhnw.emoba.modules.module06.weather_solution.model.WeatherModel
import fhnw.emoba.modules.module06.weather_solution.ui.theme.WeatherAppTheme

private val CH = Locale("de", "CH")


@Composable
fun CitiesScreen(model: WeatherModel) {
    WeatherAppTheme(model.isDarkTheme) {
        Scaffold(topBar  = { TopBar(model) },
                 content = { Body(model, it) })
    }
}

@Composable
fun TopBar(model: WeatherModel) {
    with(model) {
        TopAppBar(
            title = { Text(currentScreen.title) },
            navigationIcon = {
                IconButton(onClick = { currentScreen = Screen.WEATHER }) {
                    Icon(Icons.Filled.ArrowBack, "Back")
                }
            }
        )
    }
}


@Composable
private fun Body(model: WeatherModel, paddingValues: PaddingValues) {
    ConstraintLayout(Modifier.padding(paddingValues). fillMaxSize()) {
        val (citiesList, citiesChooser, footer) = createRefs()

        CitySearch(model, Modifier.constrainAs(citiesChooser) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
        CityList(model, Modifier.constrainAs(citiesList) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(citiesChooser.bottom, 20.dp)
            bottom.linkTo(footer.bottom, 5.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        Footer(model, Modifier.constrainAs(footer) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun CitySearch(model: WeatherModel, modifier: Modifier) {
    with(model) {
        val keyboard = LocalSoftwareKeyboardController.current
        Card(modifier) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                OutlinedTextField(value = searchtext,
                    onValueChange = { searchtext = it },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            keyboard?.hide()
                            searchtext = ""
                            launchSearch()
                        })
                        {
                            Icon(Icons.Filled.Clear, "löschen")
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            keyboard?.hide()
                            launchSearch()
                        },
                        onDone = {
                            keyboard?.hide()
                            launchSearch()
                        }
                    ),
                    placeholder = { Text("Suche") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onKeyEvent {
                            if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                                searchtext = searchtext.replace("\n", "", ignoreCase = true)
                            }
                            launchSearch()
                            true
                        }
                )
                Preference("Schweiz") { ChSwitch(model) }
                Preference("Deutschland") { DeSwitch(model) }
            }
        }
    }
}

@Composable
private fun CityList(model: WeatherModel, modifier: Modifier) {
    with(model) {
        Box(modifier) {
            if (currentCityList.isEmpty()) {
                Text(
                    text = "Keine Städte gefunden",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(10.dp)
                )
            } else {
                Divider(modifier = Modifier.align(Alignment.TopStart))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(items = currentCityList, key = { it.id }) {
                        CityCard(it, model)
                    }
                }
            }
        }
    }
}

@Composable
private fun ChSwitch(model: WeatherModel) {
    with(model) {
        Switch(checked = countryCH,
            onCheckedChange = { toggleCountryCH() }
        )
    }
}

@Composable
private fun DeSwitch(model: WeatherModel) {
    with(model) {
        Switch(checked = countryDE,
            onCheckedChange = { toggleCountryDE() }
        )
    }
}

@Composable
private fun Preference(label: String, control: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(label)
        control()
    }
}


@Composable
private fun CityCard(city: City, model: WeatherModel) {
    Card(Modifier.padding(bottom = 10.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            with(city) {
                Text(
                    text = countryCode,
                    style = MaterialTheme.typography.caption,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h5
                    )
                    Button(onClick = {
                        model.addFavCity(city)
                        model.currentScreen = Screen.WEATHER
                    }
                    ) { Icon(Icons.Filled.PlusOne, "Add") }
                }
                Text(
                    text = coordinates.toString(),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun Footer(model: WeatherModel, modifier: Modifier) {
    with(model) {
        Text(
            text = "%,d/%,d".format(CH, currentCityList.size, cityRepo.data.size),
            style = MaterialTheme.typography.caption,
            modifier = modifier
                .background(MaterialTheme.colors.primary)
                .padding(horizontal = 15.dp, vertical = 5.dp)
        )
    }
}