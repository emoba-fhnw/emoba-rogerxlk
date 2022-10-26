package kotlinplayground.module06

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    println("Demo started")
    
    GlobalScope.launch {      // launch a new coroutine in background and continue
        delay(3000L) // delay for 3 second
        println("World!")     // print after delay
    }
    
    println("Hello,")         // main thread continues while coroutine is delayed
    Thread.sleep(5000L)       // block main thread for 5 seconds to keep JVM alive
    println("Demo finished")
}