package fhnw.emoba

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import fhnw.emoba.modules.module01.helloemoba.HelloEmobaApp


/**
 * Diese Activity wird zum Starten von allen im Unterricht entwickelten Apps verwendet.
 *
 * Eine Activity ist notwendig. Alles weitere soll in der EmobaApp implementiert werden mit möglichst
 * wenig Verwendung der Activity.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var app: EmobaApp  //alle Beispiele implementieren das Interface EmobaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ToDo: hier die emoba App eintragen, die gestartet werden soll!!
        app = HelloEmobaApp

        app.initialize(activity = this)

        setContent {
            app.CreateUI()
        }
    }

    /**
     * Eine der Activity-LiveCycle-Methoden. Im Laufe des Semesters werden weitere benötigt
     * werden. Auch die leiten den Aufruf lediglich an die EmobaApp weiter.
     */
    override fun onStop() {
        super.onStop()
        app.onStop(activity = this)
    }
}

