package com.example.alphaspace.screens.fullScreen.SignInScreen.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R

@Composable
fun SideSection(
    modifier : Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {


        Image(
            painter = painterResource(id = R.drawable.alpha) ,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
                .padding(top = 50.dp , start = 8.dp , end = 8.dp)
        )

        Text(
            text = "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
        )

    }
}

@Preview
@Composable
fun SideSection_preview() {
    SideSection()
}