package com.example.alphaspace.screens.mainScreens.statisticsScreen.sections

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.textColor1

@Composable
fun StatisticsInfo(modifier : Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem(
                icon = R.drawable.clients,
                data = "+3",
                modifier = Modifier.weight(1f)
            )
            StatisticsInfoItem(
                icon = R.drawable.follower,
                data = "+28",
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem(
                icon = R.drawable.heart,
                data = "1.5K",
                modifier = Modifier.weight(1f)
            )
            StatisticsInfoItem(
                icon = R.drawable.money_heart,
                data = "125",
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            StatisticsInfoItem(
                icon = R.drawable.delivery,
                data = "100",
                modifier = Modifier.weight(1f)
            )
            StatisticsInfoItem(
                icon = R.drawable.delivery_return,
                data = "8",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun StatisticsInfoItem(
    @DrawableRes icon : Int = R.drawable.heart ,
    data : String = "1.5K",
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = iconColor_border_p1,
                shape = RoundedCornerShape(12.dp)
            )
            .height(95.dp)
            .width(120.dp)
            .background(CustomWhite0)
    ) {
        Icon(
            painter = painterResource(id = icon ),
            contentDescription = "",
            tint = iconColor_border_p1,
            modifier = Modifier.size(40.dp)
        )

        Text(
            text = "$data",
            style = TextStyle(
                color = textColor1
            )
        )
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