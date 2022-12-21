package fhnw.emoba.modules.module11.angle.ui

import android.view.MotionEvent
import java.lang.Integer.min
import java.lang.Math.toDegrees
import java.util.*
import kotlin.math.atan2
import kotlin.math.sqrt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.modules.module11.angle.model.AngleModel

private val background = Color(46, 46, 46)

@Composable
fun AngleUI(model: AngleModel) {
    BoxWithConstraints(Modifier.fillMaxSize()
                               .background(background)
                               .padding(bottom = 30.dp)) {
        with(LocalDensity.current){
            val size = min(constraints.maxHeight, constraints.maxWidth).toDp()

            AngleControl(model    = model,
                         modifier = Modifier.align(Alignment.Center)
                                            .size(size))

            AngleSlider(model    = model,
                        modifier = Modifier.align(Alignment.BottomCenter)
                                           .width(size * 0.5f))
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun AngleControl(model: AngleModel, modifier: Modifier) {
        BoxWithConstraints(modifier         = modifier.background(background),
                           contentAlignment = Alignment.Center){
            val density = LocalDensity.current.density

            val canvasSize   = (min(constraints.maxHeight, constraints.maxWidth) / density)
            var canvasCenter = Offset.Zero // der Center der Canvas (nur initial Zero)

            var delta = remember { Offset.Zero }  // die Gesamt-Verschiebung waehrend eines Drags
            Canvas(
                modifier = modifier
                    .padding(20.dp)

                    // todo 2: auf den "touch" reagieren und den neuen 'angle' im model setzen
                    // https://developer.android.com/reference/kotlin/androidx/compose/ui/input/pointer/package-summary#(androidx.compose.ui.Modifier).pointerInput(kotlin.Any,kotlin.coroutines.SuspendFunction1)

                    .pointerInput(Unit) {
                        // detectTapGestures und onPress verwenden

                        //fuer die Umrechnung der touchPosition auf den Winkel  'angleFromXY' verwenden
                    }

                    // todo 2: den 'drag' in eine neue Winkelposition umsetzen
                    // https://developer.android.com/reference/kotlin/androidx/compose/foundation/gestures/package-summary#(androidx.compose.ui.input.pointer.PointerInputScope).detectDragGestures(kotlin.Function1,kotlin.Function0,kotlin.Function0,kotlin.Function2)
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = {offset -> delta = offset},
                            onDrag = { change, dragAmount ->
                                // dragAmount ist die Differenz zum letzten Drag-Event

                                // todo 2: dragAmount zum delta (Gesamtverschiebung seit dem DragStart) hinzuzaehlen


                                //todo 2: angle auf dem model setzen (angleFromXY verwenden)

                            }
                        )
                    },

                onDraw = {
                    canvasCenter = center
                    drawCircle(color = Color(32, 32, 32))

                    val foregroundBrush = linearGradient(
                        0.0f to Color(61, 61, 61),
                        0.5f to Color(50, 50, 50),
                        1.0f to Color(42, 42, 42),
                        start = Offset.Zero,
                        end   = Offset(size.width, size.height)
                    )

                    val innerShadow = radialGradient(
                        0.0f  to Color.Transparent,
                        0.9f  to Color.Transparent,
                        0.96f to Color(255, 255, 255, (0.01f * 255).toInt()),
                        0.98f to Color(255, 255, 255, (0.05f * 255).toInt()),
                        0.99f to Color(255, 255, 255, (0.08f * 255).toInt()),
                        1.0f  to Color(255, 255, 255, (0.3f * 255).toInt()),
                        radius = size.minDimension * 0.4787234f,
                        center = Offset(center.x, center.y + 3.5f * density)
                    )

                    val innerRadius = size.minDimension * 0.4787234f
                    drawCircle(brush  = foregroundBrush,
                               radius = innerRadius)


                    // todo 1: die "Linie" muss noch in den richtigen Winkel rotiert werden
                    // https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawTransform#rotate(kotlin.Float,androidx.compose.ui.geometry.Offset)


                        val indicatorHeight = size.width * 0.20f
                        val indicatorWidth  = size.width * 0.01587302f
                        val indicatorOffset = Offset(center.x, size.width * 0.5f - innerRadius)
                        drawLine(color       = Color(159, 159, 159),
                                 start       = indicatorOffset,
                                 end         = indicatorOffset + Offset(0f, indicatorHeight),
                                 strokeWidth = indicatorWidth
                        )



                    drawCircle(brush  = innerShadow,
                               radius = innerRadius)
                })

            // DrawScope unterstuetzt noch nicht 'drawText', eine Moeglichkeit: der Text wird ausserhalb der Canvas erzeugt
            Text(text     = 0f.asText(), // todo 1: den aktuellen Winkel anzeigen
                 color    = Color(0xFFE0E0E0),
                 fontSize = (canvasSize * 0.19148936).sp)
        }

}


@Composable
private fun AngleSlider(model: AngleModel, modifier: Modifier){
    with(model){
        Slider(
            value         = angle,
            onValueChange = { angle = it },
            valueRange    = 0f..360f,
            colors        = SliderDefaults.colors(activeTrackColor   = Color(0xFFe0e0e0),
                                                  inactiveTrackColor = Color(159, 159, 159),
                                                  thumbColor         = Color(0xFFe0e0e0)),
            modifier      = modifier
        )
    }
}

//todo 3 : wie wuerde das als extension-function aussehen?
private fun angleFromXY(center: Offset, point: Offset) : Float {
    val delta = point - center
    val radius = sqrt((delta.x * delta.x) + (delta.y * delta.y))
    val nx = delta.x / radius
    val ny = delta.y / radius
    var theta = atan2(ny, nx).toDouble()
    theta = if(theta >= 0f) toDegrees(theta) else toDegrees(theta) + 360.0

    return ((theta + 90.0) % 360).toFloat()
}

private fun Float.asText() = String.format(Locale.US, "%.0f\u00b0", this)