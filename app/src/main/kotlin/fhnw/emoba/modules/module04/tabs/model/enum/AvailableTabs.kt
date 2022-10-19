package fhnw.emoba.modules.module04.tabs.model.enum

import fhnw.emoba.R

enum class AvailableTabs (val title: String, val imageInt: Int ){
    FIRST("Frühling", R.drawable.spring),
    SECOND("Sommer", R.drawable.summer),
    THIRD("Herbst", R.drawable.autumn),
    FOURTH("Winter", R.drawable.winter)
}