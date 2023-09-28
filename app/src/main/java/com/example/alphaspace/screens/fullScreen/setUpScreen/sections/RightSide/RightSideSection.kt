package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.RightSide

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RightSideSection(
    modifier: Modifier = Modifier
) {



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 26.dp, end = 26.dp)
    ) {

        AddLogo(
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(36.dp))

        AddLocation(
            modifier = Modifier.fillMaxWidth(0.8f)
        )

    }
}


@Composable
fun AddLogo(
    modifier : Modifier = Modifier
) {
    Column() {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Logo" ,
                style = textStyles.textStyle
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                Icons.Default.Add ,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun AddLocation(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Location",
                style = textStyles.textStyle
            )
            
            Spacer(modifier = Modifier.width(26.dp))

            Icon( Icons.Default.Add, contentDescription = "" )
        }
    }
}
@Preview
@Composable
fun RightSideSection_preview() {
    RightSideSection()
}