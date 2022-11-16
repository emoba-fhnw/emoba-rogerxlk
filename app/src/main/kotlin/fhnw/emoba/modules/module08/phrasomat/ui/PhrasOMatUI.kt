package fhnw.emoba.modules.module08.phrasomat.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.modules.module08.phrasomat.model.PhrasOMatModel

@Composable
fun PhrasOMatUI(model: PhrasOMatModel){
    MaterialTheme(colors = lightColors(primary = Color(0xFFCC6699))) {
        Scaffold(topBar                       = { Bar(model) },
                 content                      = { Body(model, it) },
                 floatingActionButton         = { FAB(model) },
                 floatingActionButtonPosition = FabPosition.Center,
                 isFloatingActionButtonDocked = true
        )
    }
}

@Composable
private fun Bar(model: PhrasOMatModel) {
    with(model){
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: PhrasOMatModel, paddingValues: PaddingValues) {
    ConstraintLayout(Modifier.padding(paddingValues).fillMaxSize()) {
        val margin = 20.dp

        val (phrasesBox) = createRefs()

        //todo 1: emptyList ersetzen
        PhrasesBox(phrases  = emptyList(),
                   modifier = Modifier.constrainAs(phrasesBox) {
                      start.linkTo(parent.start, margin)
                      top.linkTo(parent.top, margin)
                      end.linkTo(parent.end, margin)
                      bottom.linkTo(parent.bottom, margin * 4)
                      width = Dimension.fillToConstraints
                      height = Dimension.fillToConstraints
                  })
    }}

@Composable
private fun PhrasesBox(phrases: List<String>, modifier: Modifier){
    if(phrases.isEmpty()){
        Box(modifier         = modifier.shadow(2.dp),
            contentAlignment = Alignment.Center) {
            Text(text  = "Noch keine Phrasen",
                 style = MaterialTheme.typography.h5)
        }
    }
    else {
        // todo 1: LazyColumn mit allen bisher erzeugten Phrasen
        // SinglePhrase benutzen
    }
}

@Composable
private fun SinglePhrase(phrase: String){
    Box(modifier = Modifier.height(80.dp)
                           .padding(vertical = 5.dp, horizontal = 10.dp)){
        Text(text     = phrase,
             modifier = Modifier.align(Alignment.CenterStart))
    }
    Divider()
}

@Composable
private fun FAB(model: PhrasOMatModel) {
    with(model) {
        FloatingActionButton(onClick = {  })  //todo neue Phrase generieren lassen
           { Icon(Icons.Filled.Add, "neue Phrase") }
    }
}