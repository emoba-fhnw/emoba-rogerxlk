package fhnw.emoba.modules.module08.startrek.model

import android.content.Context
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import fhnw.emoba.R

// kann unveraendert bleiben

class StarTrekModel (val context: Context) {
    val title         = "Star-Trek App"
    val messageKirk   = "Beam us up, Scotty!"
    val reponseScotty = "Ay, Captain."

    val imageScotty   = loadImage(R.drawable.scotty)
    val imageCrew     = loadImage(R.drawable.star_trek_crew)

    var transporterStatus by mutableStateOf(0.0f)
    private set

    private val soundPlayer = MediaPlayer.create(context, R.raw.transporter)

    fun updateTransporterStatus(status: Float){
        if(status == transporterStatus){
            return
        }

        if(transporterStatus <= 0.1f && status > 0.1f ){
            playSound()
        }
        transporterStatus = status
    }

    private fun playSound(){
        soundPlayer.seekTo(0)
        soundPlayer.start()
    }

    private fun loadImage(@DrawableRes id: Int) : ImageBitmap {
        return BitmapFactory.decodeResource(context.resources, id).asImageBitmap()
    }
}