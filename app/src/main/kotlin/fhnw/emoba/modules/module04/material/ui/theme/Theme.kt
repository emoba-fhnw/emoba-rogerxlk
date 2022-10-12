package fhnw.emoba.modules.module04.material.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import fhnw.emoba.modules.module04.material.ui.theme.typographyBig

private val appDarkColors = darkColors(
    //Background colors
    primary          = Color(0xFFBB86FC),
    primaryVariant   = Color(0xFF3700B3),
    secondary        = Color(0xFF03DAC6),
    secondaryVariant = Color(0xFF03DAC6),
    background       = Color(0xFF121212),
    surface          = Color(0xFF121212),
    error            = Color(0xFFCF6679),
    
    //Typography and icon colors
    onPrimary        = Color.Black,
    onSecondary      = Color.Black,
    onBackground     = Color.White,
    onSurface        = Color.White,
    onError          = Color.Black,
)

private val appLightColors = lightColors(
    //Background colors
        primary          = lightBlue500, //Color(0xFF6200EE),
        primaryVariant   = lightBlue600, //Color(0xFF3700B3),
        secondary        = amber500,     //Color(0xFF03DAC6)
        
        secondaryVariant = Color(0xFF03DAC6),
        background       = Color.White,
        surface          = Color.White,
        error            = Color(0xFFB00020),

    //Typography and icon colors
        onPrimary        = lightBlue50, //Color.White
        onSecondary      = Color.Black,
        onBackground     = Color.Black,
        onSurface        = Color.Black,
        onError          = Color.White,
)

@Composable
fun AppTheme(darkTheme: Boolean, bigTypo: Boolean, content: @Composable() () -> Unit) {
    MaterialTheme(
            colors     = if (darkTheme) appDarkColors else appLightColors,
            typography = if (bigTypo) typographyBig else typography,
            shapes     = shapes,
            content    = content
    )
}