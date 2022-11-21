package fhnw.emoba.modules.module07.flutter.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module07.flutter.data.Flap
import fhnw.emoba.modules.module07.flutter.data.MqttConnectorFlutter
import org.json.JSONObject

object FlutterModel {
    val title = "MqttApp"
    val mqttBroker = "broker.hivemq.com"
    val topic = "fhnw/emoba/flutterapp"


    private val mqttConnector by lazy { MqttConnectorFlutter(mqttBroker) }

    var messagesReceived by mutableStateOf(0)
    var messagesPublished by mutableStateOf(0)

    var subscribedMessages = mutableStateListOf<Flap>()
    var publishMessage by mutableStateOf("")
    var flap: Flap? by mutableStateOf(null)

    fun connectAndSubscribe() {
        mqttConnector.connectAndSubscribe(topic = topic,
            onNewMessage = { subscribedMessages.add(it) })
    }

    fun publish() {
        val flap = Flap("Urs", publishMessage)
        mqttConnector.publish(topic = topic,
            flap = flap,
            onPublished = { messagesPublished++ }) //zählt erst hoch wenn message accepted from broker
    }
}