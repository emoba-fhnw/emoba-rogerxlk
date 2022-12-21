package fhnw.emoba.modules.module11.goofieball.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.R
import fhnw.emoba.modules.module11.goofieball.model.GoofieBallModel

private val background       = Color(75, 75, 75)
private val onBackground     = Color(0xFFB3E5FC)
private val canvasBackground = Color(42, 42, 42)
private val paddleColor      = Color(0xFFE0E0E0)
private val ballColor        = Color(0xFFFF9E80)

private val fontFamily = FontFamily(Font(R.font.walt_disney_script, FontWeight.Normal))

@Composable
fun GoovieBallUI(model: GoofieBallModel) {
    ConstraintLayout(Modifier.fillMaxSize().background(background)) {
        val (goovieball, lowScore, score, board) = createRefs()

        val margin = 10.dp

        GoofieBall(Modifier.constrainAs(goovieball){
            top.linkTo(parent.top, margin)
            centerHorizontallyTo(parent)
        })

        Board(model, Modifier.constrainAs(board) {
            start.linkTo(parent.start, margin)
            top.linkTo(goovieball.bottom, margin * 2)
            end.linkTo(parent.end, margin)
            bottom.linkTo(score.top, margin * 2)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        Score(model.score, Modifier.constrainAs(score) {
            start.linkTo(parent.start, margin)
            bottom.linkTo(lowScore.top, margin)
            end.linkTo(parent.end, margin)
            width = Dimension.fillToConstraints
        })

        LowScore(model.lowScore, Modifier.constrainAs(lowScore) {
            start.linkTo(parent.start, margin)
            bottom.linkTo(parent.bottom, margin)
            end.linkTo(parent.end, margin)
            width = Dimension.fillToConstraints
        })
    }
}


@Composable
private fun GoofieBall(modifier: Modifier) {
    GoofieText(text = "GoofieBall", modifier = modifier, fontSize = 96.sp)
}

@Composable
private fun LowScore(lowScore: Int, modifier: Modifier) {
    Box(modifier = modifier) {
        GoofieText(text = "Low Score",         modifier = Modifier.align(Alignment.CenterStart))
        GoofieText(text = lowScore.toString(), modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun Score(score: Int, modifier: Modifier) {
    Box(modifier = modifier) {
        GoofieText(text = "Goofie Score",   modifier = Modifier.align(Alignment.CenterStart))
        GoofieText(text = score.toString(), modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun GoofieText(text: String, modifier: Modifier, fontSize: TextUnit = 32.sp){
    Text(text       = text,
         modifier   = modifier,
         color      = onBackground,
         fontFamily = fontFamily,
         fontSize   = fontSize
    )
}

@Composable
private fun Board(model: GoofieBallModel, modifier: Modifier) {
    with(model) {
        Canvas(modifier = modifier
             //todo auf 'touch' reagieren (pointerInput/detectTapGestures)


            // todo auf 'drag' reagieren (pointerInput/detectDragGestures)
            // am Ende des Drags 'gameOver'

            , onDraw = {
                canvasSize = size

                drawRect(canvasBackground)

                drawRect(color   = paddleColor,
                         topLeft = paddlePosition,
                         size    = Size(paddleWidth, paddleHeight))

                drawCircle(color  = ballColor,
                           center = ballPosition,
                           radius = ballRadius)

                drawCircle(color  = onBackground,
                           style  = Stroke(3f),
                           center = ballPosition,
                           radius = ballRadius + 4)
            }
        )
    }
}


