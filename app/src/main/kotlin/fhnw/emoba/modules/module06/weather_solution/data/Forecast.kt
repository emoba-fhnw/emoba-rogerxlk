package fhnw.emoba.modules.module06.weather_solution.data

import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZoneOffset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asImageBitmap

class Forecast(val city: City, json: JSONObject) {
    val timezoneOffset = json.getInt("timezone_offset")
    val current = Current(json.getJSONObject("current"), timezoneOffset)
    val nextHours = json.getJSONArray("hourly").map { Hourly(it, timezoneOffset) }

    constructor(city: City, jsonString: String) : this(city, JSONObject(jsonString))
}


abstract class Base(json: JSONObject, timezoneOffset: Int) {
    val dateTime = LocalDateTime.ofEpochSecond(
        json.getLong("dt"),
        0,
        ZoneOffset.ofTotalSeconds(timezoneOffset)
    )
    val temperature = json.getDouble("temp")
    val feelsLike = json.getDouble("feels_like")
    val pressure = json.getDouble("pressure")
    val humidity = json.getDouble("humidity")
    val dew_point = json.getDouble("dew_point")
    val clouds = json.getDouble("clouds")
    val visibility = json.getDouble("visibility")
    val windSpeed = json.getDouble("wind_speed")
    val windDeg = json.getDouble("wind_deg")
    val rain = if (json.has("rain") && json.getJSONObject("rain").has("1h")) {
        json.getJSONObject("rain").getDouble("1h")
    } else {
        0.0
    }
    val weatherDescription = json.getJSONArray("weather").getJSONObject(0).getString("description")
    val weatherIcon = json.getJSONArray("weather").getJSONObject(0).getString("icon")

    var weatherImage by mutableStateOf(DEFAULT_ICON.asImageBitmap())
}


class Current(json: JSONObject, timezoneOffset: Int) : Base(json, timezoneOffset) {
    val sunrise = LocalDateTime.ofEpochSecond(
        json.getLong("sunrise"),
        0,
        ZoneOffset.ofTotalSeconds(timezoneOffset)
    )
    val sunset = LocalDateTime.ofEpochSecond(
        json.getLong("sunset"),
        0,
        ZoneOffset.ofTotalSeconds(timezoneOffset)
    )
    val uvi = json.getDouble("uvi")
}

class Hourly(json: JSONObject, timezoneOffset: Int) : Base(json, timezoneOffset) {
    val pop = json.getDouble("pop")
}