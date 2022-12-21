package fhnw.emoba.modules.module11.goofieball.model

import android.media.MediaPlayer
import androidx.activity.ComponentActivity
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import fhnw.emoba.R

class GoofieBallModel(private val activity: ComponentActivity) {
    val ballRadius    = 100f
    val paddleWidth   = 40f
    val paddleHeight  = 300f

    var canvasSize    = Size(100f, 100f)

    var ballIsMovable = false  // der Ball darf nur verschoben werden wenn man ihn "getroffen" hat,
    private set                // also nicht einfach irgendwo auf den Screen getouched hat.

    var ballPosition   by mutableStateOf(Offset(400f, 400f))
    private set

    var paddlePosition by mutableStateOf(Offset(10f, 300f))
    private set

    var lowScore       by mutableStateOf(73)     // der bisher beste Wert von allen Spielen
    private set

    var score          by mutableStateOf(100)    // der Score im aktuellen Spiel
    private set

    private var onPaddle = false     // ist der Ball gerade ueber dem Paddle?
    private var lastPaddleHit = 0L   //Zeitpunkt an dem das Paddle getroffen wurde

    private val frustratedPlayer by lazy { MediaPlayer.create(activity, R.raw.frustrated)}
    private val scoringPlayer    by lazy { MediaPlayer.create(activity, R.raw.soft_notification)}


    /**
     * Sollte aufgerufen werden sobald der Spieler auf das Spielfeld touched
     */
    fun touchDownAt(hit: Offset) {
        if((ballPosition - hit).getDistance() <= ballRadius){
            ballIsMovable = true
            lastPaddleHit = System.currentTimeMillis()
            playScoringSound()
        }
        else {
            ballIsMovable = false
            playFrustratedSound()
        }
    }

    /**
     * Ball wird nur verschoben wenn 'ballIsMovable' auf true gesetzt wurde (in 'touchDownAt')
     */
    fun moveBallBy(delta: Offset){
        if(!ballIsMovable){
            return
        }
        ballPosition += delta

        val paddleCenter = paddlePosition + Offset(paddleWidth * 0.5f, paddleHeight * 0.5f)

        // wenn man lange genug geschafft hat, das Paddle nicht zu treffen, verringert sich der Score
        // (das ist gut, schliesslich will man ja einen neuen Low Score)
        if(System.currentTimeMillis() - lastPaddleHit > 3000){
            score--
            lastPaddleHit = System.currentTimeMillis()
            playScoringSound()
        }

        //wenn man das Paddle trifft erhoeht sich der Score (das ist schlecht)
        if(!onPaddle &&
            ballPosition.x > ballRadius &&
            ballPosition.x < canvasSize.width - ballRadius &&
            ballPosition.y > ballRadius &&
            ballPosition.y < canvasSize.height - ballRadius &&
            (paddleCenter - ballPosition).getDistance() < ballRadius ) {
            lastPaddleHit = System.currentTimeMillis()
            onPaddle = true
            score += 5
            relocatePaddle()
            playFrustratedSound()
        }
        else {
            onPaddle = false
        }
    }

    /**
     * Sollte am Ende eines Spiels aufgerufen werden (wenn der Drag vom Spieler beendet wurde)
     */
    fun gameOver(){
        lowScore = Math.min(lowScore, score)
        relocatePaddle()
        ballPosition = Offset(canvasSize.width * 0.3f, canvasSize.height * 0.3f)
        score = 100
        playFrustratedSound()
    }

    /**
     * Versetzt das Paddle auf eine zufällige Position
     */
    private fun relocatePaddle(){
        val x = if (paddlePosition.x <= 10f) canvasSize.width - paddleWidth - 10f else 10f
        val y = Random.nextInt(from = 10, until = (canvasSize.height - paddleHeight - 10).toInt()).toFloat()
        paddlePosition = Offset(x, y)
    }

    private fun playFrustratedSound() {
        frustratedPlayer.seekTo(0)
        frustratedPlayer.start()
    }

    private fun playScoringSound() {
        scoringPlayer.seekTo(0)
        scoringPlayer.start()
    }
}