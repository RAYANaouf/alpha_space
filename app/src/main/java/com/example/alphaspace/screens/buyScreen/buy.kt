package com.example.alphaspace.screens.buyScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.screens.buyScreen.scenes.FirstScene
import com.example.alphaspace.screens.buyScreen.sections.ItemsSection
import com.example.alphaspace.screens.buyScreen.sections.NewBoxSection

@Composable
fun BuyScreen() {

    Column() {

        var screen by remember {
            mutableStateOf(false)
        }


        if(screen){
            NewBoxSection(
                modifier = Modifier
            )


            Spacer(modifier = Modifier.height(36.dp))

            ItemsSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp)
            )

            Spacer(modifier = Modifier.height(36.dp))
        }
        else{
            FirstScene()
        }
    }
}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun BuyScreen_preview() {
    BuyScreen()
}