package com.example.alphaspace.screens.mainScreens.profileScreen.component.sideCards.home

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
import java.time.LocalTime

@Composable
fun WorkTimeCard(
     openingTime : LocalTime,
     closingTime: LocalTime,
     modifier: Modifier = Modifier
) {

    var _openingTime = if (openingTime.hour == 0) 24 else openingTime.hour
    var _closingTime = if (closingTime.hour == 0) 24 else closingTime.hour
    var _openingTimeMinute = if (openingTime.minute == 0) openingTime.minute else openingTime.minute/10
    var _closingTimeMinute = if (closingTime.minute == 0) closingTime.minute else closingTime.minute/10


    var workingTime = (_closingTime + (_closingTimeMinute)) - (_openingTime + (_closingTimeMinute))


    var workingTime1 = if (_closingTime < _openingTime) _closingTime else 0
    var emptyTime = if (_closingTime < _openingTime) _openingTime - _closingTime else 0
    var workingTime2 = if (_closingTime < _openingTime) 24-_openingTime else 0



    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(60.dp)
            .padding(start = 16.dp, end = 26.dp)
    ){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
                if (openingTime.hour > 0) Text(text = "00" )
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


        if(_openingTime == _closingTime && openingTime.minute == closingTime.minute){
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(text = "${openingTime.hour}:${openingTime.minute}")
                    Text(text = "${closingTime.hour}:${closingTime.minute}")
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
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
        }

        else if (workingTime1 > 0){

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(workingTime1.toFloat())
            ) {
                Row(
                    horizontalArrangement = Arrangement.End ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(text = "${_closingTime}:${closingTime.minute}")
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
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
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(emptyTime.toFloat())
            ) {

            }

            if (workingTime2 != 0){
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(workingTime2.toFloat())
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(text = "${_openingTime}:${openingTime.minute}")
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
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
            }

        }

        else{
            if (openingTime.hour > 0 ){
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(_openingTime + (_openingTimeMinute).toFloat())
                ) {

                }
            }

            if (workingTime > 0){
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(workingTime.toFloat())
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(text = "${_openingTime}:${_openingTimeMinute}")
                        Text(text = "${_closingTime}:${_closingTimeMinute}")
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
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
            }

            if (_closingTime < 24){
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight((24 - _closingTime).toFloat())
                ) {

                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
                if (_closingTime < 23  ) Text(text = "24" )
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


@Preview
@Composable
fun WorkTimeCard_Preview() {
    var openingTime = LocalTime.of(10 , 0)
    var closingTime = LocalTime.of(19,0)

    WorkTimeCard(
        openingTime = openingTime,
        closingTime = closingTime
    )
}