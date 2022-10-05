package fhnw.emoba.modules.module03.funwithflaggsapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhnw.emoba.R

@Composable
fun FunWithFlagsUI(title: String) {
    Column() {
        TopBar(title = title)
        SheldonImageBox()
    }
}

@Composable
private fun TopBar(title: String) {
    TopAppBar(title = {
        Text(
            text = title,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
    })
}

@Composable
private fun SheldonImageBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        ImageWithBlockingUI(resId = R.drawable.sheldon, description = "Sheldon")
    }
}

@Composable
private fun ImageWithBlockingUI(@DrawableRes resId: Int, description: String) {
    Image(painter = painterResource(id = resId),
        contentDescription = description)
}