package fhnw.emoba.modules.module11.canvasplayground.ui

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.PathEffect.Companion.dashPathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CanvasPane() {
    // damit man weiter mit "Pixel" arbeiten kann, braucht man die "Bildschirmaufloesung"
    val density = LocalDensity.current.density

    //https://developer.android.com/reference/kotlin/androidx/compose/foundation/package-summary#Canvas(androidx.compose.ui.Modifier,kotlin.Function1)



    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onDraw   = {
            // hier ist man im 'DrawScope'
            // https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawScope

            drawRect(color = Color.Black,
                     style = Stroke(width = 1.0f))

            val radius = 100 * density

            val someGradient = radialGradient(
                0.0f to Color.Red,
                1.0f to Color.White,
                center = Offset(center.x, center.y),
                radius = radius
            )
            drawCircle(brush  = someGradient,
                       radius = radius
            )

            drawCircle(color  = Color.Gray,
                       radius = radius,
                       style  = Stroke(width      = 1.5f,
                                       pathEffect = dashPathEffect(floatArrayOf(25f, 15f), 0f)
                       )
            )

            val canvasWidth  = size.width  //Breite in "echten" Pixel. Je nach Bildschirm kann das auch bei gleich grossen Bildschirmen unterschiedlich sein
            val canvasHeight = size.height

            val quadSize = 40f * density //das Quadrat soll auch auf unterschiedlichen Bildschirmen gleich gross erscheinen

            val pivot = Offset(canvasWidth * 0.5f, 20 * density + quadSize * 0.5f) //pivot ist der Drehpunkt. Hier: der Mittelpunkt des Quadrats

            rotate(degrees = 45f,
                   pivot   = pivot){
                //ab hier wird alles um 45 Grad gedreht (um den Pivot-Punkt)
                drawRect(color   = Color.Gray,
                         topLeft = Offset((canvasWidth - quadSize) * 0.5f, 20 * density),
                         size    = Size(quadSize, quadSize))
            }

            //ab hier wieder ohne Rotation
            drawCircle(color  = Color.Red,
                       radius = 5 * density,
                       center = pivot)

            //drawText gibt es noch nicht auf 'DrawScope', hier der Workaround
            val textStyle = Paint().apply {
                textAlign = Paint.Align.CENTER
                textSize  = 73f
                color     = 0xff0000ff.toInt()  //0xaaRRGGBB
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText("hello", canvasWidth * 0.5f, canvasHeight - 80f, textStyle)  // nativeCanvas ist die Android-Basis-Implementierung von Canvas
            }
        })
}


@Preview
@Composable
private fun Preview(){
    CanvasPane()
}