package fhnw.emoba.modules.module06.weather_solution.ui

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module06.weather_solution.data.City
import fhnw.emoba.modules.module06.weather_solution.data.Forecast
import fhnw.emoba.modules.module06.weather_solution.data.Hourly
import fhnw.emoba.modules.module06.weather_solution.model.Screen
import fhnw.emoba.modules.module06.weather_solution.model.WeatherModel
import fhnw.emoba.modules.module06.weather_solution.ui.theme.WeatherAppTheme

private val CH = Locale("de", "CH")

@Composable
fun WeatherScreen(model: WeatherModel) {
    WeatherAppTheme(model.isDarkTheme) {
        Scaffold(topBar                      = { Bar(model) },
                floatingActionButton         = { FAB(model) },
                floatingActionButtonPosition = FabPosition.End,
                isFloatingActionButtonDocked = true,
                content                      = { Body(model, it) }
        )
    }
}

@Composable
private fun Bar(model: WeatherModel) {
    with(model) {
        TopAppBar(title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title)
                IconToggleButton(checked = isDarkTheme, onCheckedChange = { toggleTheme() }) {
                    Icon(imageVector = Icons.Default.DarkMode, contentDescription = "DarkMode")
                }
            }
        })
    }
}

@Composable
private fun Body(model: WeatherModel, paddingValues: PaddingValues) {
    with(model) {
        when {
            isLoading -> LoadingBox("Wetterdaten werden geladen")
            else -> AllForecasts(forecasts, model, paddingValues)
        }
    }
}

@Composable
private fun AllForecasts(
    forecasts: List<Forecast>,
    model: WeatherModel,
    paddingValues: PaddingValues
) {
    val state = rememberLazyListState()
    LazyColumn(state   = state,
              modifier = Modifier.padding(paddingValues))
    {
        items(forecasts) { ForeCastPanel(it, model) }
    }
}

@Composable
private fun ForeCastPanel(forecast: Forecast, model: WeatherModel) {
    Card(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            with(forecast.current) {
                InfoLine(
                    "${dateTime.asTime()} ${dateTime.asDate()}",
                    "\u263C \u2191${sunrise.asTime()}  \u2193${sunset.asTime()}",
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                SubHeading(forecast.city, model)
                InfoLine {
                    Heading(temperature.asText("%.1f°"))
                    Image(weatherImage, "")
                }
                InfoLine(
                    clouds.asText("\u2601 %.0f%%"),
                    rain.asText("\u2602 %.1f mm"),
                    windSpeed.asText("%.1f m/s"),
                    windDeg.asText("%.0f°")
                )
                InfoLine(humidity.asText("%.0f%%"), pressure.asText("%.0f hPa"))
            }
            Divider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            AllHourlyForecasts(forecast.nextHours)
        }
    }
}

@Composable
private fun AllHourlyForecasts(hourlyList: List<Hourly>) {
    val state = rememberLazyListState()
    LazyRow(state = state) {
        items(hourlyList) { HourlyPanel(it) }
    }
}

@Composable
private fun HourlyPanel(hourly: Hourly) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(5.dp)
    ) {
        Surface {
            Column(modifier = Modifier.padding(5.dp)) {
                with(hourly) {
                    InfoLine(dateTime.asTime(), dateTime.asText("d.M."))
                    InfoLine {
                        SubSubHeading(temperature.asText("%.1f°"))
                        Image(weatherImage, "")
                    }
                    InfoLine((pop * 100).asText("\u2602 %.0f%%"), clouds.asText("\u2601 %.0f%%"))
                    InfoLine(windSpeed.asText("%.1f m/s"), windDeg.asText("%.0f°"))
                }
            }
        }
    }
}

@Composable
private fun FAB(model: WeatherModel) {
    with(model) {
        FloatingActionButton(
            onClick = {
                currentScreen = Screen.CITIES
            }
        ) { Icon(Icons.Filled.AddLocation, "AddCity") }
    }
}


// Kandidaten fuer wiederverwendbare Funktionen

@Composable
private fun Heading(text: String) = StyledTextLine(text, MaterialTheme.typography.h3)

@Composable
private fun SubHeading(city: City, model: WeatherModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StyledTextLine(city.name, MaterialTheme.typography.h4)
        IconButton(onClick = { model.removeFavCity(city) }) {
            Icon(imageVector = Icons.Default.RemoveCircle, contentDescription = "DarkMode")
        }
    }
}

@Composable
private fun SubSubHeading(text: String) = StyledTextLine(text, MaterialTheme.typography.h5)

@Composable
private fun StyledTextLine(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun LoadingBox(message: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(message, style = MaterialTheme.typography.h5)
        CircularProgressIndicator(modifier = Modifier.padding(10.dp))
    }
}

@Composable
private fun InfoLine(vararg text: String, modifier: Modifier = Modifier) {
    InfoLine(modifier) {
        text.map { Text(it) }
    }
}

@Composable
private fun InfoLine(modifier: Modifier = Modifier, content: @Composable() (RowScope.() -> Unit)) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        content = content
    )
}


private fun LocalDateTime.asText(pattern: String): String =
    format(DateTimeFormatter.ofPattern(pattern))

private fun LocalDateTime.asDate() = asText("d.M.yy")
private fun LocalDateTime.asTime() = asText("HH:mm")

private fun Number.asText(pattern: String): String = pattern.format(CH, this)