package com.example.alphaspace.screens.statisticsScreen.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
fun StatisticsInfo(modifier : Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f).fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem()
            StatisticsInfoItem()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f).fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem()
            StatisticsInfoItem()
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f).fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem()
            StatisticsInfoItem()
        }
    }
}

@Composable
fun StatisticsInfoItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = iconColor_border_p1,
                shape = RoundedCornerShape(12.dp)
            )
            .height(95.dp)
            .width(120.dp)
            .background(CustomWhite_background)
    ) {
//        Icon(
//            painter = ,
//            contentDescription =
//        )
//
//        Text(
//            text = "1.5K"
//        )
    }
}



@Preview(widthDp = 300 , heightDp = 400)
@Composable
fun StatisticsInfo_preview() {
    StatisticsInfo()
}


@Preview
@Composable
fun StatisticsInfoItem_preview() {
    StatisticsInfoItem()
}