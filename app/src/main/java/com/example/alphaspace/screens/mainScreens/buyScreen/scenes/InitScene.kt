package com.example.alphaspace.screens.mainScreens.buyScreen.scenes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun InitScene(
    onClick : (screen : String) -> Unit = {}
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.7f)
        ) {
            InitSceneItem(
                img = R.drawable.add_stock_box,
                txt = "New box",
                modifier = Modifier.weight(2f),
                onClick = onClick
            )

            Spacer(modifier = Modifier.weight(1f))

            InitSceneItem(
                img = R.drawable.restock,
                txt = "Restock",
                onClick = onClick,
                modifier = Modifier.weight(2f)
            )
        }
    }

}

@Composable
fun InitSceneItem(
    @DrawableRes img : Int ,
    txt : String ,
    modifier: Modifier = Modifier,
    onClick: (screen : String ) -> Unit
) {

    Surface(
        color = CustomWhite0,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            color = iconColor_border_p1,
            width = 2.dp
        ),
        shadowElevation = 4.dp,
        modifier = modifier
            .height(300.dp)
            .clickable {
                onClick("$txt")
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 32.dp , end = 32.dp)
        ) {

            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "$txt",
                style = TextStyle(
                    color = iconColor_border_p1,
                    fontSize = TextUnit(
                        36f,
                        TextUnitType.Sp
                    ),
                    fontWeight = FontWeight.W600
                )
            )
        }
    }

}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun InitScene_preview() {
    InitScene()
}

@Preview
@Composable
fun InitSceneItem_preview() {
    InitSceneItem(
        img = R.drawable.new_stock,
        txt = "new box",
        onClick = {}
    )
}

