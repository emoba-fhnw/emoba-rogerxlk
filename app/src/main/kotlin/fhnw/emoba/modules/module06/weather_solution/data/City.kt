package fhnw.emoba.modules.module06.weather_solution.data

import org.json.JSONObject
import java.util.Locale

data class Coordinates(val longitude: Double, val latitude: Double) {

    override fun toString(): String {
        val latCompassDirection = if (latitude > 0.0) "N" else "S"
        val lonCompassDirection = if (longitude > 0.0) "E" else "W"

        return "${getDMS(latitude)} $latCompassDirection, ${getDMS(longitude)} $lonCompassDirection"
    }

    private fun getDMS(value: Double): String {
        val absValue = Math.abs(value)
        val degree = absValue.toInt()
        val minutes = ((absValue - degree) * 60.0).toInt()
        val seconds = (absValue - degree - minutes / 60.0) * 3600.0

        return "${degree}° ${minutes}′ ${String.format(Locale.ENGLISH, "%.4f", seconds)}″"
    }
}

data class City(
    val id: Int,
    val name: String,
    val state: String,
    val countryCode: String,
    val coordinates: Coordinates
) {

    constructor(json: JSONObject) : this(
        id = json.getInt("id"),
        name = json.getString("name"),
        state = json.getString("state"),
        countryCode = json.getString("country"),
        coordinates = Coordinates(
            json.getJSONObject("coord").getDouble("lon"),
            json.getJSONObject("coord").getDouble("lat")
        )
    )

    constructor(jsonString: String) : this(JSONObject(jsonString))

    fun asJson(): String {
        return """
                {
                "id":      $id,
                "name":    "$name",
                "state":   "$state",
                "country": "$countryCode",
                "coord":   {
                            "lon": ${coordinates.longitude},
                            "lat": ${coordinates.latitude}
                            }
                }
        """.trimIndent()
    }
}