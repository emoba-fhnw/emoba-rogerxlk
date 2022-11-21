package fhnw.emoba.modules.module07.flutter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.modules.module07.flutter.data.Flap
import fhnw.emoba.modules.module07.flutter.model.FlutterModel

@Composable
fun FlutterUI(model: FlutterModel) {
    MaterialTheme {
        Scaffold(topBar = { Bar(model) },
            content = { Body(model, it) }
        )
    }
}

@Composable
private fun Bar(model: FlutterModel) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: FlutterModel, paddingValues: PaddingValues) {
    with(model) {
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Info(mqttBroker)
            Info(topic)
            MessagesBox(model, Modifier.weight(1.0f))
           // Box(Modifier.fillMaxWidth()) {
                PublishMessage(model)
           // }
        }
    }
}

@Composable
private fun Info(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(vertical = 10.dp)
    )
}

@Composable
private fun MessagesBox(model: FlutterModel, modifier: Modifier) {
    with(model) {
        if (subscribedMessages.isEmpty()) {
            Text(
                text = "Noch keine Messages verschickt/erhalten",
                style = MaterialTheme.typography.body2
            )
        } else {
            LazyColumn(state = LazyListState(subscribedMessages.size),
                modifier = modifier
            ) {
                items(subscribedMessages) {
                    SingleMessage(flap = it)
                }
            }
        }
    }
}

@Composable
private fun SingleMessage(flap: Flap) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Row() {
                Text(
                    text = flap.sender,
                    fontSize = 10.sp,
                )
            }
            Row(modifier = Modifier.padding(top = 5.dp)) {
                Text(
                    text = flap.message,
                    fontSize = 15.sp,
                )
            }
        }
    }
    Divider()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PublishMessage(model: FlutterModel) {
    val keyboard = LocalSoftwareKeyboardController.current
    with(model) {

        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            value = publishMessage,
            onValueChange = { newText ->
                publishMessage = newText
            },
            trailingIcon = {
                IconButton(onClick = {
                    publish()
                    keyboard?.hide()
                    publishMessage = ""
                })
                {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "send")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    publish()
                    keyboard?.hide()
                    publishMessage = ""
                }
            )
        )
    }
}