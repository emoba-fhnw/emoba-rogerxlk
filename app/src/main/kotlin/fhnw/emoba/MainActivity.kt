package fhnw.emoba

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import fhnw.emoba.modules.module04.beers.BeersApp
import fhnw.emoba.modules.module04.material.MaterialApp
import fhnw.emoba.modules.module04.tabs.TabsApp
import fhnw.emoba.modules.module05.city.CityApp
import fhnw.emoba.modules.module05.multiple_screens.MultipleScreensApp
import fhnw.emoba.modules.module05.template.TemplateApp
import fhnw.emoba.modules.module06.anthems_solution.AnthemsApp
import fhnw.emoba.modules.module06.morefunwithflags.MoreFunWithFlagsApp
import fhnw.emoba.modules.module06.morefunwithflags.ui.MoreFunWithFlagsUI
import fhnw.emoba.modules.module06.video_solution.VideoApp_Solution
import fhnw.emoba.modules.module06.video_solution.ui.VideoPlayer
import fhnw.emoba.modules.module06.weather_solution.WeatherApp_Solution
import fhnw.emoba.modules.module07.flutter.FlutterApp
import fhnw.emoba.modules.module07.mqtt.MqttApp


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
//      app = CountriesApp
//      app = TabsApp
//      app = BeersApp
//        app = MultipleScreensApp
//        app = CoordinatesApp
//        app = SquadApp
//        app = CityApp
//        app = TemplateApp
//        app = MoreFunWithFlagsApp
//        app = AnthemsApp
//        app = VideoApp_Solution
//        app = WeatherApp_Solution
//        app = MqttApp
        app = FlutterApp
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

