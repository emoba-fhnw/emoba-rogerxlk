package fhnw.emoba.modules.module09.fileio.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.R
import fhnw.emoba.modules.module09.fileio.data.downloadBitmapFromFileIO
import fhnw.emoba.modules.module09.fileio.data.uploadBitmapToFileIO

class FileIOModel(val activity: ComponentActivity) {
    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val title = "file.io App"
    val originalCrew: Bitmap = loadImage(R.drawable.star_trek_crew)

    var currentTab by mutableStateOf(HomeScreenTab.UPLOAD)

    var fileioURL          by mutableStateOf<String?>(null)
    var uploadInProgress   by mutableStateOf(false)

    var downloadedCrew     by mutableStateOf<Bitmap?>(null)
    var downloadInProgress by mutableStateOf(false)
    var downloadMessage    by mutableStateOf("")


    fun uploadToFileIO() {
        uploadInProgress = true
        fileioURL = null
        modelScope.launch {
            uploadBitmapToFileIO(bitmap    = originalCrew,
                                 onSuccess = { fileioURL = it},
                                 onError   = {_, _ -> })  //todo: was machen wir denn nun?
            uploadInProgress = false
        }
    }

    fun downloadFromFileIO(){
        if(fileioURL != null){
            downloadedCrew = null
            downloadInProgress = true
            modelScope.launch {
                downloadBitmapFromFileIO(url       = fileioURL!!,
                                         onSuccess = { downloadedCrew = it},
                                         onDeleted = { downloadMessage = "File is deleted"},
                                         onError   = { downloadMessage = "Connection failed"})
                downloadInProgress = false
            }
        }
    }

    private fun loadImage(@DrawableRes id: Int) = BitmapFactory.decodeResource(activity.resources, id)

}


