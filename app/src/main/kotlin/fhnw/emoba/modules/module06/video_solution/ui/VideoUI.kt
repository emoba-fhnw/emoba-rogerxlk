package fhnw.emoba.modules.module06.video_solution.ui

import com.google.android.exoplayer2.ui.StyledPlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import androidx.annotation.NonNull
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import fhnw.emoba.modules.module06.video_solution.model.VideoModel


@Composable
fun VideoUI(model: VideoModel) {
    MaterialTheme {
        Scaffold(topBar = { Bar(model) })
        {
            Body(model, it)
        }
    }
}

@Composable
private fun Bar(model: VideoModel) {
    with(model){
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: VideoModel, paddingValues: PaddingValues) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier            = Modifier
               .fillMaxSize()
               .padding(paddingValues)
               .padding(20.dp))
    {
        VSpace(20)
        YoutubePlayer(model.youtubeURLkey)
        VSpace(40)
        VideoPlayer(model)
    }
}

@Composable
fun VideoPlayer(model: VideoModel) {
    with(model){
        val context = LocalContext.current

        // Gateway to traditional Android Views
        AndroidView(
            factory = {
                StyledPlayerView(context).apply { player = exoPlayer }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            update = {
                // The callback to be invoked after the layout is inflated.
                // exoPlayer.play() // if autoplay shall happen for example
            }
        )
    }
}


@Composable
fun YoutubePlayer(key: String) {
    val activityLifecycle = LocalLifecycleOwner.current.lifecycle
    val context = LocalContext.current

    val youtubePlayer = remember(key) {
        YouTubePlayerView(context).apply {
            activityLifecycle.addObserver(this)
            enableAutomaticInitialization = false
            initialize(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(key, 0f)
                }
            })
        }
    }

    AndroidView(
        factory = { youtubePlayer },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        update = {}
    )
}

@Composable
private fun VSpace(height: Int){
    Spacer(modifier = Modifier.height(height.dp))
}