package fhnw.emoba.modules.module01.helloemoba

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import fhnw.emoba.EmobaApp
import fhnw.emoba.modules.module01.helloemoba.ui.AppUI

/**
 * Von der App darf es nur eine Instanz geben.
 *
 * Das wird von Kotlin direkt unterstuetzt. Mit 'object'
 *
 * Alle unsere Apps implementieren das Interface 'EmobaApp' (damit sie in der 'MainActivity'
 * verwendet werden koennen'
 */
object HelloEmobaApp : EmobaApp {

    lateinit var message : String

    override fun initialize(activity: ComponentActivity) {
        message = "Guten Morgen Emoba"
    }


    //@Composable referenziert, dass die Funktion für das GUI dient.
    @Composable
    override fun CreateUI() {
        AppUI(message)
    }

}

