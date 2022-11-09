package fhnw.emoba.modules.module07.flutter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Info
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module07.flutter.model.FlutterModel

@Composable
fun FlutterUI(model: FlutterModel) {
    MaterialTheme {
        Scaffold(topBar  = { Bar(model) },
            content = { Body(model, it) }
        )
    }
}

@Composable
private fun Bar(model: FlutterModel) {
    with(model){
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: FlutterModel, paddingValues: PaddingValues) {
    with(model) {
        Column(
            Modifier.fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp)) {
            Info(mqttBroker)
            Info(topic)
            Box(Modifier.fillMaxSize()) {
                Text(text     = "$messagesReceived",
                    style    = MaterialTheme.typography.h1,
                    modifier = Modifier.align(Alignment.Center)
                )
                Button(onClick  = { publish() },
                    shape    = CircleShape,
                    modifier = Modifier.align(Alignment.BottomCenter)) {
                    Text("Publish ($messagesPublished)")
                }
            }
        }
    }
}

@Composable
private fun Info(text: String){
    Text(text    = text,
        style    = MaterialTheme.typography.h6,
        modifier = Modifier.padding(vertical = 10.dp)
    )
}