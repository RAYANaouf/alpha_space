package com.example.alphaspace.screens.mainScreens.buyScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.alphaspace.screens.mainScreens.buyScreen.scenes.InitScene
import com.example.alphaspace.screens.mainScreens.buyScreen.scenes.NewBoxScene

@Composable
fun BuyScreen() {

    Column() {

        var screen by remember {
            mutableStateOf("init")
        }


        if(screen == "New box"){
            NewBoxScene()
        }
        else if (screen == "Restock"){

        }
        else{
            InitScene(
                onClick = {
                    screen = "$it"
                }
            )
        }
    }
}

@Preview(widthDp = 1000 , heightDp = 800)
@Composable
fun BuyScreen_preview() {
    BuyScreen()
}