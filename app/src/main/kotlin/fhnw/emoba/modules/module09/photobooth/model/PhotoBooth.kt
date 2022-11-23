package fhnw.emoba.modules.module09.photobooth.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module09.photobooth.data.CameraAppConnector

class PhotoBooth(private val cameraAppConnector: CameraAppConnector) {
    private val modelScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val title = "FOTO.FIX"

    var photo by mutableStateOf<Bitmap?>(null)

    var notificationMessage by mutableStateOf("")

    fun takePhoto() {
        cameraAppConnector.getBitmap(onSuccess  = { photo = it },
                                     onCanceled = { notificationMessage = "Kein neues Bild" })
    }

    fun rotatePhoto() {
        photo?.let { modelScope.launch { photo = photo!!.rotate(90f) } }
    }
}

private fun Bitmap.rotate(degrees: Float) : Bitmap {
    val matrix = Matrix().apply {
        postRotate(degrees)
    }
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}


