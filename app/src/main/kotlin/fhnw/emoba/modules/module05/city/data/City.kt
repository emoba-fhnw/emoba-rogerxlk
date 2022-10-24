package fhnw.emoba.modules.module05.city.data

import org.json.JSONObject

//Beste Variante:
//Data class City and data class Coord, auf welche in City zugegriffen wird!!
data class City(val id: Int,
                 val name: String,
                 val state: String,
                 val country: String,
                 val coord: Coord) {

    //default constructor
    constructor(jsonString: String) : this(JSONObject(jsonString))

    constructor(jsonObject: JSONObject) : this(
        jsonObject.getInt("id"),
        jsonObject.getString("name"),
        jsonObject.getString("state"),
        jsonObject.getString("country"),
        Coord(jsonObject.getJSONObject("coord").getDouble("lon"),
            jsonObject.getJSONObject("coord").getDouble("lat"))
        )
}

data class Coord(
    val lon: Double,
    val lat: Double
)

/* !!ALTERNATIVE!!
class City2(jsonObject: JSONObject) {
    val id = jsonObject.getInt("id")
    val name = jsonObject.getString("name")
    val state = jsonObject.getString("state")
    val country = jsonObject.getString("country")

    //fetch lon & lat from coord object
    val lon = jsonObject.getJSONObject("coord").getDouble("lon")
    val lat = jsonObject.getJSONObject("coord").getDouble("lat")

    constructor(jsonString: String) : this(JSONObject(jsonString))

}
*/
