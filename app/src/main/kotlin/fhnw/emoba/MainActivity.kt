package fhnw.emoba

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import fhnw.emoba.modules.module01.helloemoba.HelloEmobaApp
import fhnw.emoba.modules.module02.basics.ComposeBasicsApp
import fhnw.emoba.modules.module03.sheldonapp.FunWithFlagsApp
import fhnw.emoba.modules.module03.sheldonapp.SheldonApp
import fhnw.emoba.modules.module04.countries.CountriesApp
import fhnw.emoba.modules.module04.countries.ui.CountriesUI
import fhnw.emoba.modules.module04.material.MaterialApp
import fhnw.emoba.modules.module04.tabs.TabsApp
import fhnw.emoba.modules.module04.viewmodel.ViewModelApp


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

//      TODO:hier die emoba App eintragen, die gestartet werden soll!!
//      app = HelloEmobaApp
//      app = ComposeBasicsApp
//      app = SheldonApp
//      app = FunWithFlagsApp
//      app = ViewModelApp
//      app = MaterialApp
      app = CountriesApp
//        app = TabsApp
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

