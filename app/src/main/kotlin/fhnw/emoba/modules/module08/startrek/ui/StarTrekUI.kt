package fhnw.emoba.modules.module08.startrek.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import fhnw.emoba.R
import fhnw.emoba.modules.module08.startrek.model.StarTrekModel

@Composable
fun StarTrekUI(model: StarTrekModel) {
    MaterialTheme(colors     = lightColors(primary = Color(0xFF9C9CFF)),
                  typography = Typography(defaultFontFamily = StarTrek)
    ) {
        Scaffold(topBar  = { Bar(model) },
                 content = { Body(model, it) }
        )
    }
}

@Composable
private fun Bar(model: StarTrekModel) {
    with(model){
        TopAppBar(title = { Text(title, style = MaterialTheme.typography.h3)})
    }
}

@Composable
private fun Body(model: StarTrekModel, paddingValues: PaddingValues) {
    with(model) {
        //todo: Column durch ConstraintLayout ersetzen
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize().background(Color(0xFFDDFFFF))) {
            val margin = 20.dp
            Msg(messageKirk, Modifier)

            Msg(reponseScotty, Modifier)

            Panini(model.imageScotty, model.transporterStatus, reversed = false,
                modifier = Modifier)

            Panini(model.imageCrew, model.transporterStatus,
                modifier = Modifier)

            Transporter(model = model,
                modifier = Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun Msg(text: String, modifier: Modifier){
    Text(text     = text,
         style    = MaterialTheme.typography.h4,
         modifier = modifier
    )
}

@Composable
private fun Transporter(model: StarTrekModel, modifier: Modifier){
    with(model){
        Slider(value         = transporterStatus,
               onValueChange = { updateTransporterStatus(it) },
               modifier      = modifier)
    }
}

@Composable
private fun Panini(bitmap: ImageBitmap, transporterStatus: Float, reversed: Boolean = true, modifier: Modifier) {
    Image(bitmap             = bitmap,
          contentDescription = "",
          contentScale       = ContentScale.FillHeight,
          modifier           = modifier.graphicsLayer(shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                                                      clip  = true,
                                                      alpha = if (reversed) transporterStatus  else  1.0f - transporterStatus
        )
    )
}

private val StarTrek = FontFamily(
    Font(R.font.star_trek_enterprise, FontWeight.ExtraLight),
    Font(R.font.star_trek_enterprise, FontWeight.Thin),
    Font(R.font.star_trek_enterprise, FontWeight.Light),
    Font(R.font.star_trek_enterprise, FontWeight.Normal),
    Font(R.font.star_trek_enterprise, FontWeight.Bold),
    Font(R.font.star_trek_enterprise, FontWeight.Black)
)

