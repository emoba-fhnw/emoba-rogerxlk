package fhnw.emoba.modules.module09.gps.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import android.graphics.BitmapFactory
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.AndroidUriHandler
import fhnw.emoba.R
import fhnw.emoba.modules.module09.gps.data.GPSConnector
import fhnw.emoba.modules.module09.gps.data.GeoPosition

class GpsModel(private val activity: ComponentActivity,
               private val locator:  GPSConnector) {

    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val title        = "'Theseus der Klugscheisser' App"
    val subtitle     = "Faden ist sooo 798 v.Chr., Ariadne!"
    val theseusImage = loadImage(R.drawable.theseus)

    val waypoints = mutableStateListOf<GeoPosition>()
    var notificationMessage by mutableStateOf("")

    fun rememberCurrentPosition(){
        modelScope.launch {
            locator.getLocation(onNewLocation      = { waypoints.add(it)
                                                       notificationMessage = "neuer Wegpunkt"
                                                     },
                                onFailure          = {}, //todo: was machen wir?
                                onPermissionDenied = { notificationMessage = "Keine Berechtigung." },  //todo: was machen wir?
            )
        }
    }

    fun removeWaypoint(position: GeoPosition) = waypoints.remove(position)

    fun showOnMap(position: GeoPosition) = AndroidUriHandler(activity).openUri(position.asOpenStreetMapsURL())

    private fun loadImage(@DrawableRes id: Int) = BitmapFactory.decodeResource(activity.resources, id).asImageBitmap()

}

