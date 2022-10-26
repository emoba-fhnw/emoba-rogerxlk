package fhnw.emoba.modules.module06.video_solution

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module06.video_solution.model.VideoModel
import fhnw.emoba.modules.module06.video_solution.ui.VideoUI

object VideoApp_Solution : EmobaApp {

    private lateinit var model: VideoModel

    override fun initialize(activity: ComponentActivity) {
        model = VideoModel(activity)
    }
    
    @Composable
    override fun CreateUI() {
        VideoUI(model)
    }
}