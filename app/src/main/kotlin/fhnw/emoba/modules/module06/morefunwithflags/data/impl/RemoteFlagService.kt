package fhnw.emoba.modules.module06.morefunwithflags.data.impl


import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagService
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize
import java.net.HttpURLConnection
import java.net.URL
import java.util.*


class RemoteFlagService : FlagService {
    private val baseURL = "https://dieterholz.github.io/StaticResources/flags_iso/"
    
    override fun requestFlag(countryCode: String, flagSize: FlagSize): ImageBitmap {
        //todo: URL entsprechend anpassen

        try {
            val url = URL("$baseURL${flagSize.size}/${countryCode.lowercase(Locale.US)}.png")
            val conn = url.openConnection() as HttpURLConnection
            conn.connect()

            val inputStream = conn.inputStream
            val allBytes = inputStream.readBytes()
            inputStream.close()

            return BitmapFactory.decodeByteArray(allBytes, 0, allBytes.size).asImageBitmap()

        } catch (e: Exception) {
            return flagSize.defaultImage
        }
    }
}