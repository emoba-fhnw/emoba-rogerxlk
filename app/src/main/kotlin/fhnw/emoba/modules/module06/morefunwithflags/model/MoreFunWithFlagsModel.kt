package fhnw.emoba.modules.module06.morefunwithflags.model


import android.media.Image
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.android.material.progressindicator.CircularProgressIndicator
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagService
import fhnw.emoba.modules.module06.morefunwithflags.data.FlagSize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MoreFunWithFlagsModel(val flagService: FlagService) {
    val title = "More Fun With Flags"
    var countryCode by mutableStateOf("")

    var flag by mutableStateOf(FlagSize.x550.defaultImage)

    var isLoading by mutableStateOf(false)

    fun getFlagAsync() {
        val backgroundJob = SupervisorJob()
        val modelScope = CoroutineScope(backgroundJob + Dispatchers.IO)


        isLoading = true
        flag = FlagSize.x550.defaultImage //Default Flag
        //hier könnte man ein loading icon einbauen

        modelScope.launch {
            flag = flagService.requestFlag(countryCode, FlagSize.x550)
            isLoading = false
        }
    }

}