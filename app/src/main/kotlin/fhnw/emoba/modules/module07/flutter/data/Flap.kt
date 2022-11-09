package fhnw.emoba.modules.module07.flutter.data

import org.json.JSONObject

//data class implementiert eine andere equals-Methode
data class Flap(
    val sender: String,
    val message: String
) {

    //nimmt json entegegen und speichert values in der Klasse ab
    constructor(json: JSONObject) : this(
        json.getString("sender"),
        json.getString("message")
    )

    //Setzt das JSON zusammen als String, damit dieser versendet werden kann
    fun asJsonString(): String {
        return """
            {
            "sender": "$sender",
            "message": "$message"
            }
        """.trimIndent()
    }


}