package com.example.alphaspace.screens.profileScreen.component

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.color4

@Composable
fun profileHeader(modifier : Modifier = Modifier ) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth(1f)
            .height(200.dp)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight(1f)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(parseColor("#fafafa")))
                    .size(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.store) ,
                    contentDescription = "profile picture" ,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(0.8f)
                )
            }

        }
        Spacer(modifier = Modifier.weight(0.5f))

        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .weight(7f)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "The name of the store",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(0.9f),

                ) {
                Text(
                    text = "Client : XX ",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    )
                )

                Text(
                    text = "follower : XX ",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    )
                )
            }
        }

        Spacer(modifier = Modifier
            .weight(0.5f)
            .background(Color.Magenta))


    }
}

@Preview(showBackground = true , widthDp = 700 , heightDp = 200)
@Composable
fun profileHeader_preview() {
    Surface(color = color4) {
        profileHeader()
    }
}