package com.example.alphaspace.screens.mainScreens.buyScreen.component

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.CustomWhite0

@Composable
fun Pointers(
    modifier : Modifier = Modifier
) {

    var content = "36/1,37/1,38/1,39/1,40/3,41/1,42/1,43/1,44/1,45/2"
    var pointerContents = content.split(",")

    Column(
        modifier = modifier
    ) {
        Text(text = "Pointers")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            pointerContents.forEach {
                var pointer = it.split("/")
                PointersItem(pointer[0].toInt() , pointer[1].toInt())
            }
        }
    }
}


@Composable
fun PointersItem(pointer : Int = 36 , contety : Int = 1) {
    Column(
        modifier = Modifier
            .height(60.dp)
            .width(30.dp)
            .background(CustomWhite0)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 0.5.dp,
                    color = Color(parseColor("#EAEAEA"))
                )
        ) {
            Text(text = "$pointer")
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 0.5.dp,
                    color = Color(parseColor("#EAEAEA"))
                )
        ) {
            Text(text = "$contety")
        }
    }
}

@Preview
@Composable
fun Pointers_preview() {
    Pointers()
}

@Preview
@Composable
fun PointersItem_preview() {
    PointersItem()
}