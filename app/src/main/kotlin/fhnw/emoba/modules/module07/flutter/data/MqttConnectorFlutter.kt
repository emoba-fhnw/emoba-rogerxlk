package fhnw.emoba.modules.module07.flutter.data

import com.hivemq.client.mqtt.datatypes.MqttQos
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish
import fhnw.emoba.modules.module07.flutter.model.FlutterModel
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.util.*


/**
 * ACHTUNG: Das ist nur eine erste Konfiguration eines Mqtt-Brokers.
 *
 * Connect, publish, subscribe
 *
 * Dieser Code kann zu 95-100% wiederverwendet werden
 *
 * Dient vor allem dazu mit den verschiedenen Parametern experimentieren zu können
 *
 * siehe die Doku:
 * https://hivemq.github.io/hivemq-mqtt-client/
 * https://github.com/hivemq/hivemq-mqtt-client
 *
 * Ein generischer Mqtt-Client (gut, um Messages zu kontrollieren)
 * http://www.hivemq.com/demos/websocket-client/
 *
 */
class MqttConnectorFlutter(
    mqttBroker: String,
    val qos: MqttQos = MqttQos.EXACTLY_ONCE
) {

    private val client = Mqtt5Client.builder()
        .serverHost(mqttBroker)
        .identifier(UUID.randomUUID().toString())
        .buildAsync()

    fun connectAndSubscribe(
        topic: String,
        onNewMessage: (Flap) -> Unit, //todo: can be done in Model as well! (String)
        onConnectionFailed: () -> Unit = {}
    ) {
        client.connectWith()
            .cleanStart(true)
            .keepAlive(30)
            .send()
            .whenComplete { _, throwable ->
                if (throwable != null) {
                    onConnectionFailed()
                } else { //erst wenn die Connection aufgebaut ist, kann subscribed werden
                    subscribe(topic, onNewMessage)
                }
            }
    }

    fun subscribe(
        topic: String,
        onNewMessage: (Flap) -> Unit //todo: can be done in Model as well! (String)
    ) {
        client.subscribeWith()
            .topicFilter(topic)
            .qos(qos)
            .noLocal(true)
            .callback { onNewMessage(Flap(JSONObject(it.payloadAsString()))) } //todo: can be done in Model as well!
            .send()
    }

    fun publish(
        topic: String,
        flap: Flap, //todo: can be done in Model as well! -> message: String
        onPublished: () -> Unit = {},
        onError: () -> Unit = {}
    ) {
        client.publishWith()
            .topic(topic)
            .payload(flap.asJsonString().asPayload()) //todo: can be done in Model as well! -> payload(message.asPayload())
            .qos(qos)
            .retain(false)  //Message soll nicht auf dem Broker gespeichert werden
            .messageExpiryInterval(120)
            .send()
            .whenComplete { _, throwable ->
                if (throwable != null) {
                    onError()
                } else {
                    onPublished()
                }
            }
    }

    fun disconnect() {
        client.disconnectWith()
            .sessionExpiryInterval(0)
            .send()
    }
}

// praktische Extension Functions
private fun String.asPayload(): ByteArray = toByteArray(StandardCharsets.UTF_8)
private fun Mqtt5Publish.payloadAsString(): String = String(payloadAsBytes, StandardCharsets.UTF_8)