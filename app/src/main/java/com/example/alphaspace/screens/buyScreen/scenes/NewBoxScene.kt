package com.example.alphaspace.screens.buyScreen.scenes

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.screens.buyScreen.sections.ItemsSection
import com.example.alphaspace.screens.buyScreen.sections.NewBoxSection
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.textColor1

@Composable
fun NewBoxScene(modifier : Modifier = Modifier) {

    /*****************       text style     *****************/
    var textStyle = TextStyle(
        color = textColor1,
        fontSize = TextUnit(30f , TextUnitType.Sp),
        fontWeight = FontWeight.W500
    )
    /*******************************************************/


    /*****************      text    ************************/

    var boxName by remember {
        mutableStateOf("")
    }

    var brandName by remember {
        mutableStateOf("")
    }

    var madeIn by remember {
        mutableStateOf("")
    }

    /*******************************************************/

    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
            ,
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
        ) {

            Image(
                painter = painterResource(id = R.drawable.package_box),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 45.dp, bottom = 16.dp)
            )
            Text(
                text = "New Box",
                style = TextStyle(
                    color = textColor1,
                    fontSize = TextUnit(24f , TextUnitType.Sp),
                    fontWeight = FontWeight.W500
                )
            )

        }

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(7f)
                .fillMaxHeight()
        ){

            Spacer(modifier = Modifier.height(65.dp))

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = iconColor_border_p1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(start = 16.dp , end = 16.dp)
            ) {
                BasicTextField(
                    value = "$boxName",
                    onValueChange = {
                        boxName = it
                    },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth()
                )

                if (boxName  == ""){
                    Text(
                        text = "Name of the box",
                        style = textStyle,
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))



            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = iconColor_border_p1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(start = 16.dp , end = 16.dp)
            ) {
                BasicTextField(
                    value = "$brandName",
                    onValueChange = {
                        brandName = it
                    },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth()
                )

                if (brandName == ""){
                    Text(
                        text = "Name of the brand",
                        style = textStyle,
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))


            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = iconColor_border_p1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(start = 16.dp , end = 16.dp)
            ) {
                BasicTextField(
                    value = "$madeIn",
                    onValueChange = {
                        madeIn = it
                    },
                    textStyle = textStyle,
                    modifier = Modifier.fillMaxWidth()
                )

                if (madeIn == ""){
                    Text(
                        text = "Made in ",
                        style = textStyle,
                    )
                }
            }


        }


    }

}

@Preview(widthDp = 1100 , heightDp = 800)
@Composable
fun NewBoxScene_preview() {
    NewBoxScene()
}