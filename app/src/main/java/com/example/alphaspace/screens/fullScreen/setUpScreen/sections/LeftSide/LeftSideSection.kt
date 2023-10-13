package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.LeftSide

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.textColor2

@Composable
fun LeftSideSection(modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = R.drawable.store),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .clip(CircleShape)
        )
        
        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = "Add photo",
            style = TextStyle(
                color = textColor2,
                fontWeight = FontWeight.W700,
                fontSize = TextUnit(36f , TextUnitType.Sp)
            )
        )

    }
}

@Preview
@Composable
fun LeftSideSection_preview() {
    LeftSideSection()
}