package fhnw.emoba.modules.module05.coordinates.ui

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhnw.emoba.modules.module05.coordinates.model.CoordinatesModel

@Composable
fun CoordinatesUI(model: CoordinatesModel){
    MaterialTheme(colors = lightColors(primary = Color(0xFFF3B423))) {
        Scaffold(topBar  = { Bar(model) },
                 content = { Body(model, it) })
    }
}

@Composable
private fun Bar(model: CoordinatesModel) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: CoordinatesModel, paddingValues: PaddingValues) {
    with(model) {
        Column(modifier            = Modifier
            .padding(paddingValues)
            .padding(20.dp),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.spacedBy(20.dp))
        {

            //todo: Ergebnis posten (auch einen funktionierenden Zwischenstand)
            //todo: disable Format-button, add syntax errors if not valid number
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = "$latitude",
                onValueChange = { latitude = it.toDouble()})
            TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = "$longitude", //wandelt Double in String um
                onValueChange = { longitude = it.toDouble()})
            
            
            Button(onClick = { convert() })                  //todo: Warum braucht convert keine Parameter und keinen Rueckgabewert?
            {
                Text("Format")
            }
            
            Box(modifier         = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                Text(coordinates, style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview
@Composable
private fun BodyPreview(){
    Body(CoordinatesModel, PaddingValues(0.dp))
}