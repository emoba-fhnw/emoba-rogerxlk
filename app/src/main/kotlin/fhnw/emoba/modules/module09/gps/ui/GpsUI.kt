package fhnw.emoba.modules.module09.gps.ui

import java.util.Locale
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocationAlt
import androidx.compose.material.icons.filled.WrongLocation
import androidx.compose.material.lightColors
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.R
import fhnw.emoba.modules.module09.gps.data.GeoPosition
import fhnw.emoba.modules.module09.gps.model.GpsModel

@Composable
fun GpsUI(model: GpsModel){
    MaterialTheme(colors     = lightColors(primary = Color(0xFF2E78D7)),
                  typography = Typography(defaultFontFamily = diogenes)) {
        val scaffoldState = rememberScaffoldState()

        Scaffold(scaffoldState                = scaffoldState,
                 topBar                       = { Bar(model) },
                 content                      = { Body(model, it) },
                 floatingActionButton         = { FAB(model) },
                 floatingActionButtonPosition = FabPosition.Center,
                 isFloatingActionButtonDocked = true
        )

        Notification(model, scaffoldState.snackbarHostState)
    }
}

@Composable
private fun Bar(model: GpsModel) {
    with(model){
        TopAppBar(title = { Text(title, style = MaterialTheme.typography.h5) })
    }
}

@Composable
private fun Body(model: GpsModel, paddingValues: PaddingValues) {
    ConstraintLayout(Modifier.padding(paddingValues).fillMaxSize()) {
        val margin = 20.dp

        val (messageBox, waypointsBox) = createRefs()

        MessageBox(model.subtitle, Modifier.constrainAs(messageBox){
            start.linkTo(parent.start, margin)
            top.linkTo(parent.top, margin)
        })

        WaypointsBox(model, Modifier.constrainAs(waypointsBox){
            start.linkTo(parent.start, margin)
            top.linkTo(messageBox.bottom, margin)
            end.linkTo(parent.end, margin)
            bottom.linkTo(parent.bottom, margin * 4)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
    }
}

@Composable
private fun MessageBox(text: String, modifier: Modifier){
    Text(text = text, modifier = modifier, style = MaterialTheme.typography.h6)
}

@Composable
private fun WaypointsBox(model: GpsModel, modifier: Modifier){
    with(model){
        if(waypoints.isEmpty()){
            Box(modifier  = modifier.border(border = BorderStroke(1.dp, MaterialTheme.colors.primary))) {
                Text(text     = "Noch keine Wegpunkte",
                     style    = MaterialTheme.typography.h5,
                     modifier = Modifier.align(Alignment.BottomCenter).padding(30.dp)
                )
                Image(bitmap             = theseusImage,
                      contentDescription = "",
                      modifier           = Modifier.padding(30.dp).align(Alignment.Center)
                )
            }
        }
        else {
            val scrollState = rememberScrollState()

            Column(modifier   = modifier.border(border = BorderStroke(1.dp, MaterialTheme.colors.primary))
                                        .verticalScroll(scrollState)) {
                waypoints.forEach { SingleWaypoint(model, it) }
            }

            LaunchedEffect(waypoints.size) {
                scrollState.animateScrollTo(scrollState.maxValue)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SingleWaypoint(model: GpsModel, position: GeoPosition){
    with(model){
         val density = LocalDensity.current.density

         ListItem(text          = { Text(position.dms(), style = MaterialTheme.typography.body2) },
                  secondaryText = { Text(String.format(ch, "%.1f m ü.M.", position.altitude)) },
                  trailing      = { IconButton(onClick = { removeWaypoint(position) })
                                      { Icon(imageVector        = Icons.Filled.WrongLocation,
                                             contentDescription = "Remove",
                                             tint               = MaterialTheme.colors.primary)
                                      }
                                      },
                  modifier      = Modifier.border(border = BorderStroke(width = 1.dp,
                                                                        color = MaterialTheme.colors.primary),
                                                  shape  = GenericShape { size, _ ->
                                                      addRect(Rect(Offset.Zero, Offset(size.width, size.height + density)))
                                                  })
                                          .padding(vertical = 5.dp)
                                          .clickable(onClick = { showOnMap(position) })
         )
    }
}

@Composable
private fun FAB(model: GpsModel) {
    with(model) {
        FloatingActionButton(
            onClick         = { rememberCurrentPosition() },
            backgroundColor = MaterialTheme.colors.primary)
        { Icon(Icons.Filled.AddLocationAlt, "Add Location") }
    }
}


@Composable
private fun Notification(model: GpsModel, snackbarState: SnackbarHostState) {
    with(model){
        if (notificationMessage.isNotBlank()) {
            LaunchedEffect(snackbarState){
                snackbarState.showSnackbar(message     = notificationMessage,
                                           actionLabel = "OK")
                notificationMessage = ""
            }
        }
    }
}

private val diogenes = FontFamily(
    Font(R.font.diogenes, FontWeight.ExtraLight),
    Font(R.font.diogenes, FontWeight.Thin),
    Font(R.font.diogenes, FontWeight.Light),
    Font(R.font.diogenes, FontWeight.Normal),
    Font(R.font.diogenes, FontWeight.Bold),
    Font(R.font.diogenes, FontWeight.Black)
)


private val ch = Locale("de", "CH")


