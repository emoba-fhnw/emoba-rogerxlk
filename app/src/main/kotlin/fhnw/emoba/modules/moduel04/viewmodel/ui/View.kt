package fhnw.emoba.modules.module04.viewmodel.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun View() {  //todo: Jeder View braucht ein ViewModel
    Scaffold(topBar                       = { Bar() },
             floatingActionButton         = { FAB() },
             floatingActionButtonPosition = FabPosition.End,
             content                      = { Body(it) })
}

@Composable
private fun Bar() { //todo: Jeder View braucht ein ViewModel
    TopAppBar(title = { Text("to be replaced") })
}

@Composable
private fun Body(paddingValues: PaddingValues) { //todo: Jeder View braucht ein ViewModel
    Box(modifier = Modifier.padding(paddingValues)
                           .padding(top    = 100.dp,
                                    bottom = 100.dp)
                           .fillMaxSize()) {
        Text(text     = "--",                               //todo
             fontSize = 156.sp,
             modifier = Modifier.align(Alignment.TopCenter)
        )
        Button(onClick  = { },                              //todo
               modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Click me")
        }
    }
}

@Composable
private fun FAB() { //todo: Jeder View braucht ein ViewModel
    FloatingActionButton(onClick = {}) //todo
    { Icon(Icons.Filled.Clear, "Clear") }
}