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
import fhnw.emoba.modules.module04.viewmodel.model.CounterModel

@Composable
fun View(counterModel: CounterModel) {  //todo: Jeder View braucht ein ViewModel
    Scaffold(topBar                       = { Bar(counterModel) },
             floatingActionButton         = { FAB(counterModel) },
             floatingActionButtonPosition = FabPosition.End,
             content                      = { Body(counterModel, it) })
}

@Composable
private fun Bar(counterModel: CounterModel) { //todo: Jeder View braucht ein ViewModel
    TopAppBar(title = { Text("${counterModel.title} ${counterModel.counter}") })
}

@Composable
private fun Body(counterModel: CounterModel, paddingValues: PaddingValues) { //todo: Jeder View braucht ein ViewModel
    Box(modifier = Modifier.padding(paddingValues)
                           .padding(top    = 100.dp,
                                    bottom = 100.dp)
                           .fillMaxSize()) {
        Text(text     = "${counterModel.counter}",                               //todo
             fontSize = 156.sp,
             modifier = Modifier.align(Alignment.TopCenter)
        )
        Button(onClick  = {counterModel.increase()},                              //todo
               modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Increase")
        }
    }
}

@Composable
private fun FAB(counterModel: CounterModel) { //todo: Jeder View braucht ein ViewModel
    FloatingActionButton(onClick = {counterModel.reset()}) //todo
    { Icon(Icons.Filled.Clear, "Clear") }
}