package com.example.alphaspace.screens.mainScreens.buyScreen.sections

import android.graphics.Color.parseColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.alphaspace.screens.mainScreens.buyScreen.component.Pointers
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun ItemsSection(modifier : Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {


            Text(
                text = "Items",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = TextUnit(30f , TextUnitType.Sp),
                    fontWeight = FontWeight.W600
                )
            )

            Spacer(modifier = Modifier.width(26.dp))

            Icon(
                Icons.Default.ArrowForward,
                contentDescription = ""
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Default.Add,
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(26.dp))
        }
        LazyVerticalGrid(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            columns = GridCells.Adaptive(350.dp)
        ){

            items(6){
                ItemsSectionItem()
            }

            item {
                AddItemHolder()
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
        shadowElevation = 3.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(150.dp)
                .height(160.dp)
                .clickable {

                }
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



@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun ItemsSection_preview() {
    ItemsSection()
}

@Preview
@Composable
fun ItemsSectionItem_preview() {
    ItemsSectionItem()
}


@Preview
@Composable
fun AddItemHolder_preview() {
    AddItemHolder()
}