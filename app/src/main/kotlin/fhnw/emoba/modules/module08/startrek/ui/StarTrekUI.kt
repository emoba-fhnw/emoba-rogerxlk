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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.R
import fhnw.emoba.modules.module08.startrek.model.StarTrekModel

@Composable
fun StarTrekUI(model: StarTrekModel) {
    MaterialTheme(
        colors = lightColors(primary = Color(0xFF9C9CFF)),
        typography = Typography(defaultFontFamily = StarTrek)
    ) {
        Scaffold(topBar = { Bar(model) },
            content = { Body(model, it) }
        )
    }
}

@Composable
private fun Bar(model: StarTrekModel) {
    with(model) {
        TopAppBar(title = { Text(title, style = MaterialTheme.typography.h3) })
    }
}

@Composable
private fun Body(model: StarTrekModel, paddingValues: PaddingValues) {
    with(model) {
        //todo: Column durch ConstraintLayout ersetzen
//        Column(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize()
//                .background(Color(0xFFDDFFFF))
//        ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize().background(Color(0xFFDDFFFF))) {
            val (kirksMsg, scottyMsg, paniniScotty, paniniCrew, transporter) = createRefs()

            val margin = 20.dp
            Msg(messageKirk, Modifier.padding(top = margin).constrainAs(kirksMsg){
                start.linkTo(parent.start, margin)
                top.linkTo(parent.top, margin)
            })

            Msg(reponseScotty, Modifier.constrainAs(scottyMsg){
                top.linkTo(kirksMsg.bottom, margin)
                end.linkTo(parent.end, margin)
            })

            Panini(
                model.imageScotty, model.transporterStatus, reversed = false,
                modifier = Modifier.constrainAs(paniniScotty){
                    start.linkTo(parent.start, margin)
                    top.linkTo(scottyMsg.bottom, margin * 2.0f)
                    end.linkTo(parent.end, margin)
                    bottom.linkTo(transporter.top, margin * 2.0f)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })

            Panini(
                model.imageCrew, model.transporterStatus,
                modifier = Modifier.constrainAs(paniniCrew){
                    start.linkTo(parent.start, margin)
                    top.linkTo(scottyMsg.bottom, margin * 2.0f)
                    end.linkTo(parent.end, margin)
                    bottom.linkTo(transporter.top, margin * 2.0f)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })

            Transporter(
                model = model,
                modifier = Modifier.constrainAs(transporter){
                    start.linkTo(parent.start, margin * 2)
                    top.linkTo(paniniCrew.bottom, margin)
                    end.linkTo(parent.end, margin * 2)
                    bottom.linkTo(parent.bottom, margin * 2)
                    width = Dimension.fillToConstraints

//                    .fillMaxWidth(0.8f)
                })
        }
    }
}

@Composable
private fun Msg(text: String, modifier: Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        modifier = modifier
    )
}

@Composable
private fun Transporter(model: StarTrekModel, modifier: Modifier) {
    with(model) {
        Slider(
            value = transporterStatus,
            onValueChange = { updateTransporterStatus(it) },
            modifier = modifier
        )
    }
}

@Composable
private fun Panini(
    bitmap: ImageBitmap,
    transporterStatus: Float,
    reversed: Boolean = true,
    modifier: Modifier
) {
    Image(
        bitmap = bitmap,
        contentDescription = "",
        contentScale = ContentScale.FillHeight,
        modifier = modifier.graphicsLayer(
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            clip = true,
            alpha = if (reversed) transporterStatus else 1.0f - transporterStatus
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

