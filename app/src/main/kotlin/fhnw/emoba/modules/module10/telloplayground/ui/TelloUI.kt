package fhnw.emoba.modules.module10.telloplayground.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import fhnw.emoba.modules.module10.telloplayground.model.TelloModel

@Composable
fun TelloUI(model: TelloModel){
    MaterialTheme() {
        with(model){
            Box(Modifier.fillMaxSize()){
                Text(text     = height.format("h: %.1f cm"),
                     style    = MaterialTheme.typography.h6,
                     modifier = Modifier.align(Alignment.TopEnd))
                Button(onClick  = { connect() },
                       enabled  = !connected && readyForNextCommand,
                       modifier = Modifier.align(Alignment.TopCenter)) {
                    Text("Connect")
                }
                Button(onClick  = { takeoff() },
                       enabled  = connected && readyForNextCommand && !flying,
                       modifier = Modifier.align(Alignment.BottomStart)) {
                    Text("Takeoff")
                }
                Button(onClick  = { land() },
                       enabled  = connected && readyForNextCommand && flying,
                       modifier = Modifier.align(Alignment.BottomCenter)) {
                    Text("Land")
                }
                Button(onClick  = { forward() },
                       enabled  = connected && readyForNextCommand && flying,
                       modifier = Modifier.align(Alignment.BottomEnd)) {
                    Text("Forward")
                }
                if(connected && readyForNextCommand && flying){
                    Box(Modifier.align(Alignment.Center).fillMaxHeight(0.5f).fillMaxWidth(0.8f)){
                        Slider(value                 = roll.toFloat(),
                               valueRange            = -100f..100f,
                               onValueChange         = { updateRoll(it.toInt()) },
                               onValueChangeFinished = { stop() },
                               modifier              = Modifier.align(Alignment.TopCenter)
                        )

                        Slider(value                 = pitch.toFloat(),
                               valueRange            = -100f..100f,
                               onValueChange         = { updatePitch(it.toInt()) },
                               onValueChangeFinished = { stop() },
                               modifier              = Modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
            }
        }
    }
}

private fun Float.format(pattern: String):String =  String.format(pattern, this)