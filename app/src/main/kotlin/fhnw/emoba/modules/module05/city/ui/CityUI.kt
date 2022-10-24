package fhnw.emoba.modules.module05.city.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import fhnw.emoba.modules.module05.city.model.CityModel

@Composable
fun CityUI(model : CityModel){
    with(model){
        Box(contentAlignment = Alignment.Center,
            modifier         = Modifier.fillMaxSize()
        ){
            Text(text = "${model.cities.size} Cities loaded")
//            Text(text  = name,
//                style = TextStyle(fontSize = 42.sp)
//            )
//            Text(text = "${model.cities.lon}")
//            Text(text = "${model.cities.coord.lon}")
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