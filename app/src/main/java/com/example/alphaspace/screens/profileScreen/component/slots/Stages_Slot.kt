package com.example.alphaspace.screens.profileScreen.component.slots

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SlotStage( text : String = "" , content : @Composable ()->Unit = {} ) {
    Column() {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {


            Text(
                text = "$text" ,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize
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


        Spacer(modifier = Modifier.height(16.dp))

        content()

    }
}

@Preview
@Composable
fun SlotStage_preview() {
    SlotStage()
}