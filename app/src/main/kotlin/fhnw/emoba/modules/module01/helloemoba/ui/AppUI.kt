package fhnw.emoba.modules.module01.helloemoba.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun AppUI(message: String){
    Text(text  = message,
         style = TextStyle(fontSize = 28.sp))
}


@Preview
@Composable
fun AppPreview(){
    AppUI("Wow!")
}