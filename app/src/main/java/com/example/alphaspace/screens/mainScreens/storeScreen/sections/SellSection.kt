package com.example.alphaspace.screens.mainScreens.storeScreen.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.categoryIcons_border
import com.example.alphaspace.ui.theme.color3
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun SellSection(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {

        Surface(
            color = color5,
            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
            border = BorderStroke(
                1.dp,
                color = categoryIcons_border,
            ),
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(end = 26.dp , top = 8.dp)
        ) {
            Column() {

                SellSectionHeader()

                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(10) {
                        SellSectionItem(
                            modifier = Modifier
                                .background(if ((it % 2) == 0) color3 else CustomWhite0)
                        )
                        Divider(
                            color = iconColor_border_p1,
                            modifier = Modifier
                                .height(0.5.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }

    }

}


@Composable
fun SellSectionHeader() {
    Row(
        modifier = Modifier
            .height(35.dp)
            .fillMaxWidth()
            .background(CustomWhite0)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.5f)
        ) {
            Text(text = "Product")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "Client")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "Color")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        ) {
            Text(text = "Ref")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "Price")
        }

    }

    Divider(
        color = iconColor_border_p1,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun SellSectionItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(95.dp)
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.shoes2),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxHeight(0.8f)

            )
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "rayan aouf")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "white/black")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        ) {
            Text(text = "RtkD458")
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(text = "3200.00")
        }


    }

}

@Preview(widthDp = 700 , heightDp = 300)
@Composable
fun SellSection_prev() {
    SellSection()
}

@Preview
@Composable
fun SellSectionItem_preview1() {
    SellSectionItem()
}

@Preview
@Composable
fun SellSectionItem_preview2() {
    SellSectionItem(modifier = Modifier.background(CustomWhite0))
}

