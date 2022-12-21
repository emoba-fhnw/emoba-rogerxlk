package fhnw.emoba.modules.module11.led.ui

import kotlin.math.min
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Led(ledColor: Color,
        on:       Boolean,
        modifier: Modifier){

    Canvas(modifier = modifier,
           onDraw   = {

           // some calculations
           val width  = size.width
           val height = size.height

           val ledSize     = min(width, height)
           val innerRadius = 0.7f * ledSize * 0.5f

           val offsetX = if(width > height) 0.5f * (width - ledSize) else 0.0f
           val offsetY = if(height > width) 0.5f * (height - ledSize) else 0.0f

           // setup all gradients needed
           val frameGradient = linearGradient(
                0.0f  to rgb( 20,  20,  20, 0.65f),
                0.15f to rgb( 20,  20,  20, 0.65f),
                0.26f to rgb( 41,  41,  41, 0.65f),
                0.26f to rgb( 41,  41,  41, 0.64f),
                0.85f to rgb(200, 200, 200, 0.41f),
                1.0f  to rgb(200, 200, 200, 0.35f),
                start = Offset(offsetX + 0.25f * ledSize, offsetY + 0.25f * ledSize),
                end   = Offset(offsetX + 0.75f * ledSize, offsetY + 0.75f * ledSize)
            )

            val ledOnGradient = linearGradient(
                0.0f  to ledColor.derive(0.77f),
                0.50f to ledColor.derive(0.5f),
                1.0f  to ledColor,
                start = Offset(offsetX + 0.15f * ledSize, offsetY + 0.15f * ledSize),
                end   = Offset(offsetX + 0.85f * ledSize, offsetY + 0.85f * ledSize)
            )

            val ledOffGradient = linearGradient(
                0.0f  to ledColor.derive(0.2f),
                0.50f to ledColor.derive(0.13f),
                1.0f  to ledColor.derive(0.2f),
                start = Offset(offsetX + 0.15f * ledSize, offsetY + 0.15f * ledSize),
                end   = Offset(offsetX + 0.85f * ledSize, offsetY + 0.85f * ledSize)
            )

            val glow = radialGradient(
                0.0f  to Color.Transparent,
                0.65f to ledColor.copy(alpha = 0.05f),
                0.70f to ledColor.copy(alpha = 0.35f),
                1.0f  to Color.Transparent,
                center =  Offset(center.x, center.y),
                radius = ledSize * 0.5f
            )

            val innerShadow = radialGradient(
                0.0f to Color.Transparent,
                0.2f to Color.Transparent,
                0.3f to rgb(0, 0, 0, 0.0078125f),
                0.4f to rgb(0, 0, 0, 0.015625f),
                0.5f to rgb(0, 0, 0, 0.03125f),
                0.6f to rgb(0, 0, 0, 0.0625f),
                0.7f to rgb(0, 0, 0, 0.125f),
                0.8f to rgb(0, 0, 0, 0.25f),
                0.9f to rgb(0, 0, 0, 0.5f),
                1.0f to rgb(0, 0, 0, 1.0f),
                radius  = 0.7f * ledSize * 0.5f,
                center = Offset(center.x, center.y),
            )

            val highlightGradient = radialGradient(
                0.0f to Color.White,
                1.0f to Color.Transparent,
                center = Offset(center.x - 0.3f * ledSize, center.y - 0.3f * ledSize),
                radius = 0.3f * ledSize
            )

            //draw the LED
            drawCircle(frameGradient)

            if(on){
                drawCircle(ledOnGradient, radius = innerRadius)
                drawCircle(innerShadow,   radius = innerRadius)  //innerShadow und Glow muessen separat als Kreis gezeichnet werden. In html-Canvas oder JavaFX-Canvas waeren das Eigenschaften des "on-Circles"
                drawCircle(glow)
            }
            else {
                drawCircle(ledOffGradient, radius = innerRadius)
                drawCircle(innerShadow,    radius = innerRadius)
            }

            drawCircle(highlightGradient, radius = 0.58f * ledSize * 0.5f)
        })
}

//some convenient functions

private fun rgb(r: Int, g: Int, b: Int, alpha: Float) : Color = Color(r, g, b, (alpha * 255).toInt())

//do it the kotlin-way as an extension-function
private fun Color.derive(brightness: Float) : Color {
    val original = android.graphics.Color.valueOf(red, green, blue, alpha)
    val hsv = FloatArray(3)
    android.graphics.Color.colorToHSV(original.toArgb(), hsv)
    hsv[2] = brightness
    return Color(android.graphics.Color.HSVToColor(hsv))
}

//if you like it the css-way (oh no, seriously?)

//private fun derive(color: Color, brightness: Float): Color {
//    val original = android.graphics.Color.valueOf(color.red, color.green, color.blue, color.alpha)
//    val hsv = FloatArray(3)
//    android.graphics.Color.colorToHSV(original.toArgb(), hsv)
//    hsv[2] = brightness
//    return Color(android.graphics.Color.HSVToColor(hsv))
//}


@Preview
@Composable
private fun PreviewLedON(){
    Led(ledColor = Color.Red, on = true, modifier = Modifier.fillMaxSize())
}

@Preview
@Composable
private fun PreviewLedOFF(){
    Led(ledColor = Color.Red, on = false, modifier = Modifier.fillMaxSize())
}