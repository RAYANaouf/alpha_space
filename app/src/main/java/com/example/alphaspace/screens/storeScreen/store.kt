package com.example.alphaspace.screens.storeScreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.screens.storeScreen.sections.CommandSection
import com.example.alphaspace.screens.storeScreen.sections.PriceSection
import com.example.alphaspace.screens.storeScreen.sections.SellSection
import com.example.alphaspace.screens.storeScreen.sections.StockSection

@Composable
fun StoreScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp , start = 26.dp , end = 26.dp , bottom = 16.dp)
    ) {

        StockSection(
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.50f)
        )

        CommandSection(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth(0.30f)
                .fillMaxHeight(0.70f)
        )


        SellSection(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(0.70f)
                .fillMaxHeight(0.45f)
        )

        PriceSection(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth(0.30f)
                .fillMaxHeight(0.25f)
        )


    }
}

@Preview(widthDp = 1400 , heightDp = 800)
@Composable
fun StoreScreen_preview() {
    StoreScreen()
}