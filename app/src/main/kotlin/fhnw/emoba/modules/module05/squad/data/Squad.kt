package fhnw.emoba.modules.module05.squad.data

import org.json.JSONArray
import org.json.JSONObject

class Squad(jsonObject: JSONObject){
    val squadName  = jsonObject.getString("squadName")
    val homeTown   = jsonObject.getString("homeTown")
    val formed     = jsonObject.getInt("formed")
    val secretBase = jsonObject.getString("secretBase")
    val active     = jsonObject.getBoolean("active")
    val members    = members(jsonObject.getJSONArray("members"))
    
    constructor(jsonString: String) : this(JSONObject(jsonString))
    
    private fun members(memberArray: JSONArray) : List<Member>{
        val list: MutableList<Member> = mutableListOf()
        for (i in 0 until memberArray.length()) {
            list.add(Member(memberArray.getJSONObject(i)))
        }
        return list
    }

}