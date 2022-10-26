package fhnw.emoba.modules.module06.morefunwithflags.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagService
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize

class MoreFunWithFlagsModel(val flagService: FlagService) {
    val title = "More Fun With Flags"
    var countryCode by mutableStateOf("")
    
    var flag by mutableStateOf(FlagSize.x550.defaultImage)
    
    fun loadFlag() {
        flag = flagService.requestFlag(countryCode, FlagSize.x550)
    }
}