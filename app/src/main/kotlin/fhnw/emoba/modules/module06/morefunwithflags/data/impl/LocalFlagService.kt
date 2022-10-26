package fhnw.emoba.modules.module06.morefunwithflags.data.impl

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import fhnw.emoba.R
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagService
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize

class LocalFlagService(val context: Context) : FlagService {

    override fun requestFlag(countryCode: String, flagSize: FlagSize): ImageBitmap {
        return BitmapFactory.decodeResource(context.resources, R.drawable.slowakei).asImageBitmap()
    }
}