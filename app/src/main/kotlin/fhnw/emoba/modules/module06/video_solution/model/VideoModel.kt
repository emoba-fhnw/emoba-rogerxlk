package fhnw.emoba.modules.module06.video_solution.model

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.MimeTypes
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 *  for static url resources to play:
 *  add in Gradle:  implementation 'com.google.android.exoplayer:exoplayer:2.18.1'
 *
 *  for youtube keys to play: add
 *  implementation 'com.pierfrancescosoffritti.androidyoutubeplayer:core:11.1.0'
 */

class VideoModel(context: ComponentActivity) {

    val title = "Got Vid?"

    val staticVidURL = "https://michaeljob.ch/vid/partytime480.mp4" //RockTheRing

    var youtubeURLkey   by mutableStateOf("lXgkuM2NhYI") //Heros

    val exoPlayer = ExoPlayer.Builder(context).build().apply {
        addMediaItem(MediaItem.Builder().setUri(staticVidURL)
                                        .setMimeType(MimeTypes.APPLICATION_MP4)
                                        .build())
        prepare()
    }

}