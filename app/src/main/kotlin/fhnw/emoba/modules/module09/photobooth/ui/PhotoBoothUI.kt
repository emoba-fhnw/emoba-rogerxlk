package fhnw.emoba.modules.module09.photobooth.ui

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.lightColors
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.modules.module09.photobooth.model.PhotoBooth

@Composable
fun PhotoBootUI(model: PhotoBooth) {
    MaterialTheme(colors = lightColors(primary = Color(0xFF2E78D7)) ) {
        val scaffoldState = rememberScaffoldState()

        Scaffold(scaffoldState                = scaffoldState,
                 topBar                       = { Bar(model) },
                 content                      = { Body(model, it) },
                 floatingActionButton         = { FAB(model) },
                 floatingActionButtonPosition = FabPosition.Center,
                 isFloatingActionButtonDocked = true
        )

        Notification(model, scaffoldState.snackbarHostState)
    }
}

@Composable
private fun Bar(model: PhotoBooth) {
    with(model) {
        TopAppBar(title = { Text(title) })
    }
}

@Composable
private fun Body(model: PhotoBooth, paddingValues: PaddingValues) {
    with(model) {
        ConstraintLayout(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            val margin = 10.dp

            val (messageBox, selfie) = createRefs()

            if (photo != null) {
                Photo(bitmap   = photo!!,
                      model    = model,
                      modifier = Modifier.constrainAs(selfie) {
                              top.linkTo(parent.top, margin)
                              start.linkTo(parent.start, margin)
                              end.linkTo(parent.end, margin)
                              width = Dimension.fillToConstraints})
            } else {
                MessageBox(Modifier.constrainAs(messageBox) {
                        centerTo(parent)
                    })
            }
        }
    }
}

@Composable
private fun Photo(bitmap: Bitmap, model: PhotoBooth, modifier: Modifier){
    with(model){
        Image(bitmap             = bitmap.asImageBitmap(),
              contentDescription = "",
              modifier           = modifier.clickable(onClick = { rotatePhoto() }))
    }
}

@Composable
private fun MessageBox(modifier: Modifier){
    Text(text     = "Take a Picture",
         style    = MaterialTheme.typography.h5,
         modifier = modifier)
}

@Composable
private fun FAB(model: PhotoBooth) {
    with(model) {
        FloatingActionButton(
            onClick         = { takePhoto() },
            backgroundColor = MaterialTheme.colors.primary
        ) { Icon(Icons.Filled.CameraAlt, "") }
    }
}


@Composable
private fun Notification(model: PhotoBooth, snackbarState: SnackbarHostState) {
    with(model){
        if (notificationMessage.isNotBlank()) {
            LaunchedEffect(snackbarState){
                snackbarState.showSnackbar(message     = notificationMessage,
                                           actionLabel = "OK")
                notificationMessage = ""
            }
        }
    }
}