package fhnw.emoba.modules.module06.weather_solution.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import fhnw.emoba.R

private val Lato = FontFamily(
    Font(R.font.lato_extra_light, FontWeight.ExtraLight),
    Font(R.font.lato_hai, FontWeight.Thin),
    Font(R.font.lato_lig, FontWeight.Light),
    Font(R.font.lato_reg, FontWeight.Normal),
    Font(R.font.lato_bol, FontWeight.Bold),
    Font(R.font.lato_bla, FontWeight.Black)
)

val typography = Typography(
    defaultFontFamily = Lato,
)