package fhnw.emoba.modules.module06.morefunwithflags.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import fhnw.emoba.modules.module06.morefunwithflags.model.MoreFunWithFlagsModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MoreFunWithFlagsUI(model: MoreFunWithFlagsModel) {
    val uriHandler = LocalUriHandler.current
    val keyboard = LocalSoftwareKeyboardController.current
    MaterialTheme {
        Scaffold(
                topBar = { TopAppBar(title = { Text("More Fun with Flags") }) })
        {
            with(model) {
                ConstraintLayout(Modifier.padding(it)
                                         .padding(20.dp)
                                         .fillMaxSize())
                {
                    val (link, searchField, flagBox) = createRefs()
                    
                    Text("countrycode.org",
                         style    = MaterialTheme.typography.body1,
                         color    = MaterialTheme.colors.primary,
                         modifier = Modifier.constrainAs(link){
                                              end.linkTo(parent.end)
                                              top.linkTo(parent.top) }
                                           .clickable(onClick = { uriHandler.openUri("https://countrycode.org") }))
                    OutlinedTextField(
                            value           = countryCode,
                            onValueChange   = { countryCode = it },
                            placeholder     = { Text("ISO 2 Country Code") },
                            modifier        = Modifier.constrainAs(searchField){
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                top.linkTo(link.bottom, 20.dp)
                                width = Dimension.fillToConstraints
                            },
                            trailingIcon    = {
                                IconButton(onClick = { countryCode = "" }) {
                                    Icon(Icons.Filled.Clear, "delete")
                                }
                            },
                            singleLine      = true,
                            keyboardOptions = KeyboardOptions(imeAction    = ImeAction.Done,
                                                              autoCorrect  = false,
                                                              keyboardType = KeyboardType.Ascii),
                            keyboardActions = KeyboardActions(onDone = {
                                keyboard?.hide()
                                model.getFlagAsync()
//                                if(isLoading){
//                                    CircularProgressIndicator()
//                                }
                            }))
                    Box(contentAlignment = Alignment.Center,
                        modifier         = Modifier.constrainAs(flagBox){
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(searchField.bottom)
                            bottom.linkTo(parent.bottom)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        })
                    {
                        Image(bitmap             = flag,
                              contentDescription = countryCode,
                              modifier           = Modifier.fillMaxWidth().shadow(4.dp),
                              contentScale       = ContentScale.FillWidth
                        )
                    }
                }
            }
        }
    }
}