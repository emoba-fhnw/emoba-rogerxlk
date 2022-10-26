package fhnw.emoba.modules.module06.anthems.model

import java.util.Locale
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object AnthemsModel {
    private const val baseURL = "https://dieterholz.github.io/StaticResources/anthems"
    
    var countryCode by mutableStateOf("")
    
    var playerIsReady by mutableStateOf(true)
    
    private var currentlyPlaying = ""  // wird nur intern gebraucht, soll kein Recompose ausloesen, daher auch kein MutableState
    
    private val player = MediaPlayer().apply {
        setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
        )
        setOnPreparedListener {
            start()
        }
        setOnCompletionListener { playerIsReady = true }
    }
    
    fun startPlayer(){
        playerIsReady = false
        try {
            if (currentlyPlaying == countryCode && !player.isPlaying) {
                player.start()
            } else {
                currentlyPlaying = countryCode
                player.reset()
                player.setDataSource("$baseURL/${countryCode.uppercase(Locale.getDefault())}.mp3")
                player.prepareAsync()
            }
        } catch (e: Exception) {
            playerIsReady = true
        }
    }
    
    fun pausePlayer() {
        player.pause()
        playerIsReady = true
    }
}