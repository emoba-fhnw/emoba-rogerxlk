package fhnw.emoba.modules.module05.city.data

import org.json.JSONArray
import org.json.JSONObject

class City(jsonObject: JSONObject) {
    val id = jsonObject.getInt("id")
    val name = jsonObject.getString("name")
    val state = jsonObject.getString("state")
    val country = jsonObject.getString("country")
    val coord = coord(jsonObject.getJSONArray("coord"))

    constructor(jsonString: String) : this(JSONObject(jsonString))

    private fun coord(coordArray: JSONArray) : List<Coord>{
        val list: MutableList<Coord> = mutableListOf()
        for (i in 0 until coordArray.length()) {
            list.add(Coord(coordArray.getJSONObject(i)))
        }
        return list
    }
}