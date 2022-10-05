package fhnw.emoba.modules.module03.funwithflaggsapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.R
import kotlinx.coroutines.launch

@Composable
fun FunWithFlagsUI(title: String) {
    Column {
        MyScaffold(title = title)
    }
}

@Composable
private fun SheldonImageBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ImageWithBlockingUI(resId = R.drawable.sheldon, description = "Sheldon")
    }
}

@Composable
private fun CzeckImage() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        ImageWithBlockingUI(resId = R.drawable.tschechien, description = "Flag of Czeck Republic")
    }
}

@Composable
private fun SlovakiaImage() {

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),

    ) {
        ImageWithBlockingUI(resId = R.drawable.slowakei, description = "Flag of Slovakia")
    }
}

@Composable
private fun ImageWithBlockingUI(@DrawableRes resId: Int, description: String) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = description,
    )
}

@Composable
private fun MyScaffold(title: String) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { SheldonImageBox() },
        topBar = {
            TopAppBar(
                backgroundColor = Color(156, 166, 143),
                title = {
                    Text(
                        text = title,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(5.dp)
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {}
            Column {
                SlovakiaImage()
                Spacer(modifier = Modifier.fillMaxHeight(0.74f))
                CzeckImage()
            }
        }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    FunWithFlagsUI("")

}