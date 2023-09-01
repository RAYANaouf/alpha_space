package com.example.alphaspace.screens.profileScreen.component.sideCards.home

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor

@Composable
fun WorkTimeCard(modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(60.dp)
            .padding(start = 16.dp, end = 26.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(9f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
                    Text(text = "00" )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Divider(modifier = Modifier
                        .width(1.dp)
                        .height(10.dp)
                        .background(Color(parseColor("#fbfbfb")))
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(10f)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween ,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = "10")
                Text(text = "7")
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(2f)
            ){
                Surface(shape = RoundedCornerShape(8.dp) , color = navigationRail_backgroundColor) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .height(10.dp)
                            .background(navigationRail_backgroundColor)
                    ) {

                    }
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxHeight()
                .weight(5f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
                    Text(text = "12" )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Divider(modifier = Modifier
                        .width(1.dp)
                        .height(10.dp)
                        .background(Color(parseColor("#fbfbfb")))
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun WorkTimeCard_Preview() {
    WorkTimeCard()
}