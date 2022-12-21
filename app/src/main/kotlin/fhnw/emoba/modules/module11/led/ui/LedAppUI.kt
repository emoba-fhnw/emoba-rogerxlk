package fhnw.emoba.modules.module11.led.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module11.led.model.LedModel

@Composable
fun LedAppUI (model: LedModel){
    with(model){
        MaterialTheme {
            Box(modifier = Modifier.fillMaxSize()
                                   .padding(10.dp)){
                Led(ledColor = color,
                    on       = on,
                    modifier = Modifier.align(Alignment.Center)
                                       .fillMaxWidth()
                                       .fillMaxHeight(0.8f))

                // intentionally ugly
                Button(onClick  = { changeColor() },
                       modifier = Modifier.align(Alignment.BottomEnd)) {
                    Text("Change Color")
                }

                Switch(checked         = on,
                       onCheckedChange = { on = it },
                       modifier        = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }

}


@Preview
@Composable
private fun Preview(){
    LedAppUI(model = LedModel)
}