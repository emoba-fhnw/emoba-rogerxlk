package fhnw.emoba.modules.module05.city.data

import org.json.JSONObject

class City(jsonObject: JSONObject) {
    val id = jsonObject.getInt("id")
    val name = jsonObject.getString("name")
    val state = jsonObject.getString("state")
    val country = jsonObject.getString("country")

    //fetch lon & lat from coord object
    val lon = jsonObject.getJSONObject("coord").getDouble("lon")
    val lat = jsonObject.getJSONObject("coord").getDouble("lat")

    //Alternative: Eigen data class Coord, auf welche hier zugegriffen wird. Zeile 11/12 wären überflüssig
    //val coord = Coord(jsonObject.getJSONObject("coord").getDouble("lon"), jsonObject.getJSONObject("coord").getDouble("lat"))


    constructor(jsonString: String) : this(JSONObject(jsonString))


}

/*
data class City2(val id: Int, val name: String, ....) {
    val state = jsonObject.getString("state")
    val country = jsonObject.getString("country")

    //fetch lon & lat from coord object
    val lon = jsonObject.getJSONObject("coord").getDouble("lon")
    val lat = jsonObject.getJSONObject("coord").getDouble("lat")

    //Alternative
    //val coord = Coord(jsonObject.getJSONObject("coord").getDouble("lon"), jsonObject.getJSONObject("coord").getDouble("lat"))


    constructor(jsonString: String) : this(JSONObject(jsonString))
    constructor(jsonObject: JSONObject) : this(jsonObject.getInt("id"),jsonObject.getString("name"), .. )


}
 */
