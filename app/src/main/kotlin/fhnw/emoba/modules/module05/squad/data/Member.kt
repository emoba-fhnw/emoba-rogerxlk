package fhnw.emoba.modules.module05.squad.data

import org.json.JSONArray
import org.json.JSONObject

private fun powers(powerArray: JSONArray) : List<String>{
    val list: MutableList<String> = mutableListOf()
    for (i in 0 until powerArray.length()) {
        list.add(powerArray.getString(i))
    }
    return list
}

class Member(val name: String,
             val age: Int,
             val secretIdentity: String,
             val powers: List<String>){  //diesen Konstruktor gibt es hauptsaechlich fuer TestZwecke, z.B. im Preview
    
    constructor(jsonObject: JSONObject) : this(jsonObject.getString("name"),
                                               jsonObject.getInt("age"),
                                               jsonObject.getString("secretIdentity"),
                                               powers(jsonObject.getJSONArray("powers")))
    
    override fun toString(): String {
        return "Member(name='$name', age=$age, secretIdentity='$secretIdentity', powers=$powers)"
    }
    
}