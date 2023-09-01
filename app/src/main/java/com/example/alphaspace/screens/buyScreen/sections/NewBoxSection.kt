package com.example.alphaspace.screens.buyScreen.sections

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.textColor1

@Composable
fun NewBoxSection(modifier : Modifier = Modifier) {

    /*****************       text style     *****************/
    var textStyle = TextStyle(
        color = textColor1,
        fontSize = TextUnit(30f , TextUnitType.Sp),
        fontWeight = FontWeight.W500
    )
    /*******************************************************/

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.package_box),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(0.7f)
            )
            Text(
                text = "New Box",
                style = TextStyle(
                    color = textColor1,
                    fontSize = TextUnit(22f , TextUnitType.Sp),
                    fontWeight = FontWeight.W500
                )
            )
        }

        Column(

            modifier = Modifier
                .fillMaxHeight()
                .weight(4f)
                .padding(start = 12.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Text(
                    text = "Name",
                    modifier = Modifier.width(150.dp),
                    style = textStyle
                )
                Text(
                    text = ":",
                    modifier = Modifier,
                    style = textStyle
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "xxx *** xxx ***",
                    modifier = Modifier,
                    style = textStyle
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Brand",
                    modifier = Modifier.width(150.dp),
                    style = textStyle
                )
                Text(
                    text = ":",
                    modifier = Modifier,
                    style = textStyle
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "xxx ***",
                    style = textStyle
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Made in",
                    modifier = Modifier.width(150.dp),
                    style = textStyle
                )
                Text(
                    text = ":",
                    modifier = Modifier,
                    style = textStyle
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "xxx ***",
                    modifier = Modifier,
                    style = textStyle
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(4f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Text(
                    text = "Buy Price",
                    modifier = Modifier.width(200.dp),
                    style = textStyle
                )
                Text(
                    text = ":",
                    modifier = Modifier,
                    style = textStyle
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "****.** DA",
                    modifier = Modifier,
                    style = textStyle
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Sell Prices",
                    modifier = Modifier.width(200.dp),
                    style = textStyle
                )
                Text(
                    text = ":",
                    modifier = Modifier,
                    style = textStyle
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "****.** DA",
                    style = textStyle
                )

                Icon(
                    Icons.Default.Edit,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 26.dp)
                )
            }



        }
    }

}


@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun NewBox_preview() {
    NewBoxSection()
}