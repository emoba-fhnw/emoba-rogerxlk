package fhnw.emoba.modules.module10.telloplayground.data

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketTimeoutException
import java.nio.charset.StandardCharsets

class TelloConnector(private val ip:          String,
                     private val commandPort: Int,
                     private val statePort:   Int) {

    private val commandSocket by lazy {
        DatagramSocket(commandPort).apply {
            soTimeout = 3000
        }
    }

    private val statusSocket by lazy { DatagramSocket(statePort) }

    fun connect(onFinished: (response: String) -> Unit) {
        commandSocket.connect(InetAddress.getByName(ip), commandPort)

        onFinished(sendCommandAndWait("command"))
    }

    // commands sending a response
    fun takeoff(        onFinished: (response: String) -> Unit = {}) = onFinished(sendCommandAndWait("takeoff"))
    fun land   (        onFinished: (response: String) -> Unit = {}) = onFinished(sendCommandAndWait("land"))
    fun forward(x: Int, onFinished: (response: String) -> Unit = {}) = onFinished(sendCommandAndWait("forward $x"))


    // fire and forget commands
    fun rc(leftRight: Int, forwardBack: Int, upDown: Int, yaw: Int) = fireAndForgetCommand("rc $leftRight $forwardBack $upDown $yaw")
    fun stop()                                                      = fireAndForgetCommand("stop")


    fun startStatusNotification(onNewStatus: (String) -> Unit){
        while(true){
            val packetSize    = 512
            val receivePacket = DatagramPacket(ByteArray(packetSize), packetSize)

            statusSocket.receive(receivePacket)

            onNewStatus(String(receivePacket.data, 0, receivePacket.length, StandardCharsets.UTF_8))
        }
    }

    private fun sendCommandAndWait(command: String) : String {
        fireAndForgetCommand(command)

        return waitForResponse()
    }

    private fun fireAndForgetCommand(command: String){
        val buf    = command.toByteArray(StandardCharsets.UTF_8)
        val packet = DatagramPacket(buf, buf.size, commandSocket.inetAddress, commandSocket.port)

        commandSocket.send(packet)
    }

    private fun waitForResponse () : String {
        try {
            val packetSize    = 256
            val receivePacket = DatagramPacket(ByteArray(packetSize), packetSize)

            commandSocket.receive(receivePacket)

            return String(receivePacket.data, StandardCharsets.UTF_8)
        } catch (e: SocketTimeoutException) {  //just a workaround
            println("Timeout, damn!")
            return "OK"
        }
    }

}