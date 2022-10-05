package fhnw.emoba.modules.module02.basics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val lorem =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid unt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco aboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

@Composable
fun BasicsUI(title: String) {
    Column(content = {
        TopAppBar(
            content = {
                Text(text = "JetPack Compose Basics",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)
            })

        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Heading(text = "Lorem ipsum")
            })

        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Paragraph(text = lorem)
            })

        BasicDivider()

        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Text(text = "dolor lit", fontSize = 16.sp)
                Switch(checked = true, onCheckedChange = {})
            })
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Text(text = "amet", fontSize = 16.sp)
                Switch(checked = true, onCheckedChange = {})
            })
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Text(text = "consecturer", fontSize = 16.sp)
                Checkbox(checked = true, onCheckedChange = {})
            })

        BasicDivider()

        Row(content = {
            Spacer(modifier = Modifier.padding(100.dp))
        }) 
        
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Cancel")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Save")
                }
            })

//        BasicRow {
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = "Cancel")
//            }
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = "Save")
//            }
//        }

    })
}

@Composable
private fun Heading(text:String){
    Text(text = text,
    fontSize = 42.sp)
}

@Composable
private fun Paragraph(text: String){
    Text(text = text,
        fontSize = 16.sp,
        maxLines = 5,
        overflow = TextOverflow.Ellipsis
        )
}

@Composable
private fun BasicDivider(){
    Divider(
       modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
    )
}

@Composable
private fun BasicRow(content: @Composable RowScope.() -> Unit){
    Row(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
        content = {}
    )
}

@Preview
@Composable
fun DefaultPreview() {
    BasicsUI("Hallo Preview")

}