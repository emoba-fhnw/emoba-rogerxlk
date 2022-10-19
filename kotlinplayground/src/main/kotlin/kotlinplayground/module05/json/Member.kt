package kotlinplayground.module05.json

import org.json.JSONArray
import org.json.JSONObject

class Member(jsonObject: JSONObject){
    val name           = jsonObject.getString("name")
    val age            = jsonObject.getInt("age")
    val secretIdentity = jsonObject.getString("secretIdentity")
    val powers         = powers(jsonObject.getJSONArray("powers"))
    
    private fun powers(powerArray: JSONArray) : List<String>{
        val list: MutableList<String> = mutableListOf()
        for (i in 0 until powerArray.length()) {
            list.add(powerArray.getString(i))
        }
        return list
    }
    
    override fun toString(): String {
        return "Member(name='$name', age=$age, secretIdentity='$secretIdentity', powers=$powers)"
    }
}