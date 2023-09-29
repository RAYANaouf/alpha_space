package com.example.alphaspace.screens.mainScreens.buyScreen.scenes

import android.graphics.Color.parseColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.screens.mainScreens.buyScreen.component.Pointers
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.categoryIcons_content
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.textColor1
import com.example.alphaspace.ui.theme.textColor2

@Composable
fun NewBoxScene(modifier : Modifier = Modifier) {

    /*****************       text style     *****************/
    var textFeildStyle = TextStyle(
        color = textColor1,
        fontSize = TextUnit(30f , TextUnitType.Sp),
        fontWeight = FontWeight.W500
    )

    var textHintStyle = TextStyle(
        color = textColor2,
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

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.package_box),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "New Box",
                    style = TextStyle(
                        color = textColor1,
                        fontSize = TextUnit(24f , TextUnitType.Sp),
                        fontWeight = FontWeight.W500
                    )
                )
            }

            Box(
                modifier = Modifier.weight(4f)
            ) {

            }

        }

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(7f)
                .fillMaxHeight()
        ){

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(3f)
            ) {
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
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    BasicTextField(
                        value = "$boxName",
                        onValueChange = {
                            boxName = it
                        },
                        textStyle = textFeildStyle,
                        maxLines = 1,
                        singleLine = true,
                        cursorBrush = SolidColor(categoryIcons_content),
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (boxName  == ""){
                        Text(
                            text = "Name of the box",
                            style = textHintStyle,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

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
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    BasicTextField(
                        value = "$brandName",
                        onValueChange = {
                            brandName = it
                        },
                        textStyle = textFeildStyle,
                        maxLines = 1,
                        singleLine = true,
                        cursorBrush = SolidColor(categoryIcons_content),
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (brandName == ""){
                        Text(
                            text = "Name of the brand",
                            style = textHintStyle,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

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
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    BasicTextField(
                        value = "$madeIn",
                        onValueChange = {
                            madeIn = it
                        },
                        textStyle = textFeildStyle,
                        maxLines = 1,
                        singleLine = true,
                        cursorBrush = SolidColor(categoryIcons_content),
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (madeIn == ""){
                        Text(
                            text = "Made in ",
                            style = textHintStyle,
                        )
                    }
                }
            }

            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(start = 8.dp , end = 8.dp),
                modifier = Modifier.weight(4f)
            ) {
                items(4){
                    ItemsSectionItem()
                }
                item {
                    AddItemHolder()
                }
            }


        }


    }

}

@Composable
fun ItemsSectionItem(modifier: Modifier = Modifier) {
    Surface(
        color = CustomWhite0,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp , color = iconColor_border_p1),
        shadowElevation = 3.dp,
        modifier = Modifier
            //when i use clickable i found out that i should use the clip to control the click wave
            .clip(RoundedCornerShape(12.dp))
            .clickable { }
    ) {

        Row(
            modifier = modifier
                .width(350.dp)
                .height(180.dp)
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
            ) {

                Image(

                    painter = painterResource(id = R.drawable.shoes1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Color",
                        modifier = Modifier.width(80.dp)
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.width(16.dp)
                    )
                    Text(text = "Black")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Contety",
                        modifier = Modifier.width(80.dp)
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.width(16.dp)
                    )
                    Text(text = "6")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Pointers(
                    modifier = Modifier
                )
            }
        }
    }
}


@Composable
fun AddItemHolder() {
    Surface(
        color = Color(parseColor("#F0F0F0")),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp , color = iconColor_border_p1),
        shadowElevation = 3.dp,
        modifier =Modifier.clickable {  }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(350.dp)
                .height(180.dp)
                .clickable {  }
        ) {

            Icon(
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = "",
                tint = iconColor_border_p1,
                modifier = Modifier
                    .size(100.dp)

            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Add Item",
                style = TextStyle(
                    color = iconColor_border_p1,
                    fontSize = TextUnit(18f , TextUnitType.Sp),
                    fontWeight = FontWeight.W500
                )
            )

        }
    }
}


@Preview(widthDp = 1100 , heightDp = 800 )
@Composable
fun NewBoxScene_preview() {
    NewBoxScene()
}