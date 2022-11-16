package fhnw.emoba.modules.module08.lotto

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module08.lotto.model.LottoModel
import fhnw.emoba.modules.module08.lotto.ui.LottoUI

object LottoApp : EmobaApp {
    private lateinit var model: LottoModel

    override fun initialize(activity: ComponentActivity) {
        model = LottoModel
    }

    @Composable
    override fun CreateUI() {
        LottoUI(model)
    }
}





