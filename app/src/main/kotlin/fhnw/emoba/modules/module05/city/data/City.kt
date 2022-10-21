package fhnw.emoba.modules.module05.city.data

import fhnw.emoba.modules.module05.squad.data.Member
import org.json.JSONArray
import org.json.JSONObject

class City(jsonObject: JSONObject) {
    val id = jsonObject.getInt("id")
    val name = jsonObject.getString("name")
    val state = jsonObject.getString("state")
    val country = jsonObject.getString("country")
    val coord = jsonObject.getJSONObject("cord")

    val lon = coord.getJSONObject("lon")
    val lat = coord.getJSONObject("lat")


    constructor(jsonString: String) : this(JSONObject(jsonString))

}