package kotlinplayground.module05.json

import org.json.JSONArray
import org.json.JSONObject

class Squad(jsonObject: JSONObject) {
    val squadName = jsonObject.getString("squadName")
    val homeTown = jsonObject.getString("homeTown")
    val formed = jsonObject.getInt("formed")
    val secretBase = jsonObject.getString("secretBase")
    val active = jsonObject.getBoolean("active")
    val members = members(jsonObject.getJSONArray("members"))



    private fun members(memberArray: JSONArray) : List<Member>{
        val list: MutableList<Member> = mutableListOf()
        for (i in 0 until memberArray.length()) {
            list.add(Member(memberArray.getJSONObject(i))) //holt für jeden Member die JsonObjects und speichert sie in der Member Klasse
        }
        return list
    }

}