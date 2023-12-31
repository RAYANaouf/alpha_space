package com.example.alphaspace.screens.statisticsScreen.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.CustomWhite_background
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun CalendarSection(
    modifier : Modifier = Modifier
) {


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {

        Surface(
            color = CustomWhite_background,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                color = iconColor_border_p1,
                width = 1.dp
            ),
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight()
        ) {

            Column(
                modifier = Modifier
            ) {

            }

        }
    }

}

@Preview(widthDp = 350 , heightDp = 450)
@Composable
fun CalendarSection_preview() {
    CalendarSection()
}