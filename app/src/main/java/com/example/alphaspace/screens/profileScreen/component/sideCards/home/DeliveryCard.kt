package com.example.alphaspace.screens.profileScreen.component.sideCards.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R

@Composable
fun DeliveryCard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(60.dp)
            .padding(start = 16.dp, end = 26.dp)
    ) {


        Row(
            modifier = Modifier.weight(5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.delivery),
                contentDescription = "" ,
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Image(
                painter = painterResource(id = R.drawable.delivery),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Image(
                painter = painterResource(id = R.drawable.delivery),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )

        }

        Row (
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
        ){
            Image(
                painter = painterResource(id = R.drawable.unchecked),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}