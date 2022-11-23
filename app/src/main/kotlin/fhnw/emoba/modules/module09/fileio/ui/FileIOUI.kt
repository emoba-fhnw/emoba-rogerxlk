package fhnw.emoba.modules.module09.fileio.ui

import android.graphics.Bitmap
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.lightColors
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.modules.module09.fileio.model.FileIOModel
import fhnw.emoba.modules.module09.fileio.model.HomeScreenTab

@Composable
fun FileIOUI(model: FileIOModel) {
    MaterialTheme(colors = lightColors(primary = Color(0xFF646DCC))) {
        val scaffoldState = rememberScaffoldState()

        Scaffold(scaffoldState                = scaffoldState,
                 topBar                       = { Bar(model) },
                 content                      = { Body(model, it) },
                 floatingActionButton         = { FAB(model) },
                 floatingActionButtonPosition = FabPosition.Center,
                 isFloatingActionButtonDocked = true
        )
    }
}

@Composable
private fun Bar(model: FileIOModel) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
fun Body(model: FileIOModel, paddingValues: PaddingValues) {
    with(model){
        Column(modifier = Modifier.padding(paddingValues))
        {
            TabRow(selectedTabIndex = model.currentTab.ordinal) {
                for (tab in HomeScreenTab.values()) {
                    Tab(text     = { Text(tab.title) },
                        selected = tab == currentTab,
                        onClick  = { currentTab = tab }
                    )
                }
            }
            Crossfade(targetState   = currentTab,  // auch die Uebergaenge zwischen den Tabs kann man animieren
                      animationSpec = tween(500)) { tab ->
                when (tab) {
                    HomeScreenTab.UPLOAD   -> { UploadTab(model) }
                    HomeScreenTab.DOWNLOAD -> { DownloadTab(model) }
                }
            }
        }
    }
}

@Composable
fun UploadTab(model: FileIOModel) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (picture, fileio) = createRefs()

        val margin = 20.dp

        CrewPicture(model.originalCrew, Modifier.constrainAs(picture){
            start.linkTo(parent.start, margin)
            top.linkTo(parent.top,  margin )
            end.linkTo(parent.end, margin)
            width = Dimension.fillToConstraints
        })

        UploadBox(model, Modifier.constrainAs(fileio){
            top.linkTo(picture.bottom, margin)
            start.linkTo(parent.start, margin * 2)
            end.linkTo(parent.end, margin * 2)
            width = Dimension.fillToConstraints
        })
    }
}

@Composable
private fun UploadBox(model: FileIOModel, modifier: Modifier){
    with(model){
        when {
            uploadInProgress  -> { LinearProgressIndicator( modifier) }
            fileioURL != null -> { CenteredText(fileioURL!!, modifier) }
            else              -> { CenteredText("Not uploaded to file.io", modifier) }
        }
    }
}


@Composable
private fun DownloadTab(model: FileIOModel) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (response, fileio) = createRefs()
        val margin = 20.dp

        ResponseBox(model, modifier = Modifier.constrainAs(response){
            start.linkTo(parent.start, margin)
            top.linkTo(parent.top,  margin )
            end.linkTo(parent.end, margin)
            bottom.linkTo(parent.bottom, margin * 6)
            width = Dimension.fillToConstraints
        })

        DownloadBox(model, Modifier.constrainAs(fileio){
            bottom.linkTo(parent.bottom, margin * 5)
            start.linkTo(parent.start, margin * 2)
            end.linkTo(parent.end, margin * 2)
            width = Dimension.fillToConstraints
        })
    }
}

@Composable
private fun ResponseBox(model: FileIOModel, modifier: Modifier){
    with(model){
        if(downloadedCrew != null){
            CrewPicture(downloadedCrew!!, modifier)
        }
        else {
            Box(modifier, contentAlignment = Alignment.Center){
                when {
                    downloadMessage.isNotBlank() -> { CenteredText(downloadMessage) }
                    fileioURL != null            -> { CenteredText("Not downloaded") }
                    else                         -> { CenteredText("No URL for download") }
                }
            }
        }
    }
}

@Composable
private fun DownloadBox(model: FileIOModel, modifier: Modifier){
    with(model){
        when {
            downloadInProgress -> { LinearProgressIndicator(modifier = modifier) }
            fileioURL != null  -> { CenteredText(fileioURL!!, modifier = modifier) }
        }
    }
}

@Composable
private fun FAB(model: FileIOModel) {
    with(model) {
        when {
            currentTab == HomeScreenTab.UPLOAD -> FloatingActionButton(
                onClick = { uploadToFileIO() },
                backgroundColor = MaterialTheme.colors.primary)
            { Icon(Icons.Filled.CloudUpload, "Upload") }

            fileioURL != null -> FloatingActionButton(
                onClick = { downloadFromFileIO() },
                backgroundColor = MaterialTheme.colors.secondary)
            { Icon(Icons.Filled.CloudDownload, "Download") }
        }
    }
}

@Composable
private fun CrewPicture(bitmap: Bitmap, modifier: Modifier){
    Image(bitmap             = bitmap.asImageBitmap(),
          contentDescription = "",
          contentScale       = ContentScale.FillWidth,
          modifier           = modifier.graphicsLayer(shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                                                      clip  = true))
}

@Composable
private fun CenteredText(text: String, modifier: Modifier = Modifier){
    Text(text      = text,
         textAlign = TextAlign.Center,
         modifier  = modifier)
}

