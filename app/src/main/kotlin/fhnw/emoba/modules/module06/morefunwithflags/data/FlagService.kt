package fhnw.emoba.modules.module06.morefunwithflags.data

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

private fun defaultImage(size: Int): ImageBitmap {
    val bitmap = Bitmap.createBitmap(
            size,
            size,
            Bitmap.Config.ALPHA_8
    )
    return bitmap.asImageBitmap()
}

enum class FlagSize(val size: Int, val defaultImage: ImageBitmap = defaultImage(size)) {
    x16(16),
    x24(24),
    x32(32),
    x48(48),
    x64(64),
    x128(128),
    x550(550)
}

interface FlagService {
    fun requestFlag(countryCode: String, flagSize: FlagSize): ImageBitmap
}