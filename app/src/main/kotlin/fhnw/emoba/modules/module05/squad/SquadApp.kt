package fhnw.emoba.modules.module05.squad

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module05.squad.data.SquadRepository
import fhnw.emoba.modules.module05.squad.model.SquadModel
import fhnw.emoba.modules.module05.squad.ui.SquadUI

object SquadApp : EmobaApp {
    private lateinit var model: SquadModel
    
    override fun initialize(activity: ComponentActivity) {
        val repo = SquadRepository
        repo.loadSquad(activity)
        model = SquadModel(repo)
    }
    
    @Composable
    override fun CreateUI() {
        SquadUI(model)
    }
}