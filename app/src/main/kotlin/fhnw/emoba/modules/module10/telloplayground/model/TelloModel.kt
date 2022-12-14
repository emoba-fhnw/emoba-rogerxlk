package fhnw.emoba.modules.module10.telloplayground.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module10.telloplayground.data.TelloConnector

class TelloModel(private val tello: TelloConnector) {

    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    // Tello's state
    var connected           by mutableStateOf(false)
    var readyForNextCommand by mutableStateOf(true)
    var flying              by mutableStateOf(false)

    var height by mutableStateOf(0.0f)
    //todo: add battery-level

    // Needed for rc command
    // see https://emissarydrones.com/what-is-roll-pitch-and-yaw
    var pitch by mutableStateOf(0)  // forward/backward
        private set

    var roll by mutableStateOf(0)  // left/right
        private set

    //todo: add yaw and throttle


    // the fire-and-forget Commands (no need to do them async)

    fun updatePitch(value: Int) {
        if (value == pitch || !connected) {
            return
        }
        pitch = value
        tello.rc(roll, pitch, 0, 0)
    }

    fun updateRoll(value: Int) {
        if (value == roll || !connected) {
            return
        }
        roll = value
        tello.rc(roll, pitch, 0, 0)
    }

    fun stop() {
        roll  = 0
        pitch = 0

        tello.stop()
    }

    //todo add 'throttle', 'yaw', 'emergency'


    // the waitForResponse-Commands (must be done async to avoid ui freeze and have to use a callback)

    fun connect() {
        readyForNextCommand = false
        modelScope.launch {
            tello.connect {
                startStatusListener()
                connected = true
                readyForNextCommand = true
            }
        }
    }

    fun takeoff() = onTello { takeoff    { flying = true } } // interesting: this is bound to TelloConnector, you can use the functions of TelloConnector here
    fun land()    = onTello { land       { flying = false } }
    fun forward() = onTello { forward(50) }

    //todo: add 'up'


    private fun startStatusListener() {
        modelScope.launch {
            tello.startStatusNotification {
                // todo get battery level
                height = it.split(";")[13].split(":")[1].toFloat()
            }
        }
    }

    private fun onTello(todo: TelloConnector.() -> Unit) {
        if (connected && readyForNextCommand) {
            readyForNextCommand = false
            modelScope.launch {
                todo(tello)
                readyForNextCommand = true
            }
        }
    }

}