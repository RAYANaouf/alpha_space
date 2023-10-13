package com.example.alphaspace.screens.mainScreens.statisticsScreen.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun InteractionSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ){

        Surface(
            color = CustomWhite0,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                color = iconColor_border_p1,
                width = 2.dp
            ),
            shadowElevation = 2.dp,
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
        ) {
            Column() {

            }
        }

        Spacer(modifier = Modifier.width(32.dp))


        Surface(
            color = CustomWhite0,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                color = iconColor_border_p1,
                width = 2.dp
            ),
            shadowElevation = 2.dp,
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
        ) {
            Column() {

            }
        }



    }
}

@Preview(widthDp = 900 , heightDp = 450)
@Composable
fun InteractionSection_preview() {
    InteractionSection()
}