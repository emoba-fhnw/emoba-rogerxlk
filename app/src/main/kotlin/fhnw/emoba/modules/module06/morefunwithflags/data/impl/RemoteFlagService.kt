package fhnw.emoba.modules.module06.morefunwithflags.data.impl


import androidx.compose.ui.graphics.ImageBitmap
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagService
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize


class RemoteFlagService : FlagService {
    private val baseURL = "https://dieterholz.github.io/StaticResources/flags_iso/"
    
    override fun requestFlag(countryCode: String, flagSize: FlagSize): ImageBitmap {
        //todo: via URL das Bild laden
        
        return flagSize.defaultImage
    }
}