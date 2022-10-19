package fhnw.emoba.modules.module05.city.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import fhnw.emoba.modules.module05.city.model.CityModel

@Composable
fun CityUI(model : CityModel){
    with(model){
        Box(contentAlignment = Alignment.Center,
            modifier         = Modifier.fillMaxSize()
        ){
            Text(text  = title,
                style = TextStyle(fontSize = 42.sp)
            )
        }
    }
}

//@Composable
//fun CityUI(model: CityModel) {
//    MaterialTheme(
//        colors = lightColors(
//            primary = Color(0xFFF3B423),
//            surface = Color(0xFFFFFCED)
//        )
//    ) {
//        Scaffold(topBar = { Bar(model) })
//        {
//            Body(model, it)
//        }
//    }
//}
//
//@Composable
//private fun Bar(model: CityModel) {
//    with(model) {
//        TopAppBar(title = { Text(title) })
//    }
//}
//
//@Composable
//private fun Body(model: CityModel, paddingValues: PaddingValues) {
//    with(model.city) {
//        ConstraintLayout(
//            Modifier
//                .padding(paddingValues)
//                .padding(start = 10.dp, end = 10.dp)
//                .fillMaxSize()
//        )
//        {
//            //TODO
//            val (squadname,
//                homeTownLabel, homeTownValue,
//                formedLabel, formedLabelValue,
//                secretBaseLabel, secretBaseValue,
//                activeLabel, activeValue,
//                membersLabel,
//                membersList) = createRefs()
//
//        }
//    }
//}d