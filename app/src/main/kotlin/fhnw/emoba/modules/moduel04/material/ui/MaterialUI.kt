package fhnw.emoba.modules.module04.material.ui

import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.modules.module04.material.model.MaterialModel
import fhnw.emoba.modules.module04.material.ui.theme.AppTheme

@Composable
fun MaterialUI(model: MaterialModel) {
    val scaffoldState = rememberScaffoldState()

    with(model) {
        AppTheme(
            darkTheme,
            typoBig
        ) {  //immer wenn sich 'darkTheme' aendert wird Recompose ausgeloest
            Scaffold(
                topBar = { Bar(model, scaffoldState) },
                drawerContent = { Drawer(model) },
                floatingActionButton = { FAB(model) },
                floatingActionButtonPosition = FabPosition.End,
                scaffoldState = scaffoldState
            ) {
                Body(model, it)
            }
        }
    }
}

@Composable
private fun Bar(model: MaterialModel, scaffoldState: ScaffoldState) {
    with(model) {
        TopAppBar(title = {
            Text(
                text = title,
                fontSize = 20.sp //hier wird die Fontsize explizit gesetzt und wird somit nicht durch die biggerFont Einstellung beeinflusst
            )
        },
            navigationIcon = { DrawerIcon(scaffoldState) })
    }
}

@Composable
private fun DrawerIcon(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
        Icon(Icons.Filled.Menu, "Drawer öffnen")
    }
}

@Composable
private fun Body(model: MaterialModel, paddingValues: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.aligned(Alignment.CenterVertically),
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ) {
        Text(
            text = "Darkula",
            style = MaterialTheme.typography.h2
        )
        Text(
            text = "The choice is yours",
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(20.dp))
        ThemeSwitch(model)
    }
}

@Composable
private fun Drawer(model: MaterialModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Einstellungen",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(top = 5.dp, bottom = 20.dp)
        )
        Divider()
        Preference("Dark Theme") { ThemeSwitch(model) }
        Preference("Bigger Font") {
            Checkbox(
                checked = model.typoBig,
                onCheckedChange = { model.toggleFontSize() })
        }
        Preference("RadioBtn") { RadioButton(selected = true, onClick = {}) }
        Preference("another Btn") { Button(onClick = {}) { Text("Click Me") } }
    }
}

@Composable
private fun FAB(model: MaterialModel) {
    with(model) {
        FloatingActionButton(onClick = { toggleTheme() })
        {
            Icon(Icons.Filled.Home, "Home")
        }
    }
}

@Composable
private fun ThemeSwitch(model: MaterialModel) {
    with(model) {
        Switch(checked = darkTheme,
            onCheckedChange = { toggleTheme() }
        )
    }
}

@Composable
private fun Preference(label: String, control: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(label)
        control.invoke()
    }
    Divider()
}