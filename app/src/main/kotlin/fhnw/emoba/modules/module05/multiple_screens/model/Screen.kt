package fhnw.emoba.modules.module05.multiple_screens.model

import androidx.annotation.DrawableRes
import fhnw.emoba.R

enum class Screen(val title: String, @DrawableRes val resId: Int) {
    HOME     ("1985",     R.drawable.home_sweet_home),
    YEAR_1955("1955",     R.drawable.back_to_future_date),
    YEAR_2015("2015",     R.drawable.hoverboard),
    ABOUT    ("About Me", R.drawable.i_am_groot),
}