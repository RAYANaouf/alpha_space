package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.mainScreens.profileScreen.component.sideCards.home.WorkTimeCard
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1
import java.time.LocalTime

@Composable
fun WorkingTime(
    openingTime : LocalTime,
    closingTime : LocalTime,
    formattedOpeningTime : String,
    formattedClosingTime : String,
    onOpeningTimeClick : ()->Unit,
    onClosingTimeClick : ()->Unit
) {
    Column {
        Text(
            text = "Working Time",
            style = textStyles.textStyle_size1
        )

        Spacer(modifier = Modifier.height(20.dp))

       Row {
           SetTime(
               text = "Open",
               onTimeSet = {
                   onOpeningTimeClick()
               },
               time = "$formattedOpeningTime",
               modifier = Modifier
                   .weight(1f)
           )

           Spacer(modifier = Modifier.width(26.dp))

           SetTime(
               text = "Close",
               onTimeSet = {
                   onClosingTimeClick()
               },
               time = "$formattedClosingTime",
               modifier = Modifier
                   .weight(1f)
           )
       }

        Spacer(modifier = Modifier.height(26.dp))


        WorkTimeCard(
            openingTime = openingTime,
            closingTime = closingTime
        )


    }
}

@Composable
fun SetTime(
    modifier: Modifier = Modifier ,
    text : String ,
    time: String,
    onTimeSet : ()->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(45.dp)
    ) {
        Text(
            text = "$text : ",
            style = textStyles.textStyle_size1.copy(fontSize = TextUnit(26f , TextUnitType.Sp)),
            modifier = Modifier
                .weight(2f)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .padding(start = 26.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        onTimeSet()
                    }
                    .border(
                        border = BorderStroke(2.dp, iconColor_border_p1),
                        RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = CustomWhite0
                    )
                    .padding(6.dp)
            ){
                Text(
                    text = time,
                    style = textStyles.textStyle_size1
                )
            }
        }

    }
}


@Preview
@Composable
fun WorkingTime_preview() {
    WorkingTime(
        openingTime = LocalTime.of(10,0),
        closingTime = LocalTime.of(7,0),
        formattedOpeningTime = "09:00",
        formattedClosingTime = "11:00",
        onOpeningTimeClick = {

        },
        onClosingTimeClick = {

        }
    )
}