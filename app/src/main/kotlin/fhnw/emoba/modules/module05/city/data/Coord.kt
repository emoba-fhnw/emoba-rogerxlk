package fhnw.emoba.modules.module05.city.data

import org.json.JSONObject

class Coord(val lon: Double,
            val lat: Double) {

    constructor(jsonObject: JSONObject) : this(
        jsonObject.getDouble("lon"),
        jsonObject.getDouble("lat")
    )

    override fun toString(): String {
        return "Coord(lon=$lon, lat=$lat)"
    }
}

